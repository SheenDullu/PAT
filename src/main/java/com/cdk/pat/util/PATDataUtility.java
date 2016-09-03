package com.cdk.pat.util;

import com.cdk.pat.dao.AppraisalDAO;
import com.cdk.pat.dao.AssociateDAO;
import com.cdk.pat.dto.AppraisalDTO;
import com.cdk.pat.dto.AssociateDTO;
import com.cdk.pat.exception.PATException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PATDataUtility {

    @Autowired
    AssociateDAO associateDAO = null;

    @Autowired
    AppraisalDAO appraisalDAO = null;

    public boolean readLines(String filePath) throws PATException {
        List<String[]> listOfRecords = CSVUtility.readLines(filePath);
        List<Date> appraisalsDateList = buildAppraisalsDates(listOfRecords.get(0));
        if (null != listOfRecords) {
            for (int i = 1; i < listOfRecords.size(); i++) {
                buildAssociate(appraisalsDateList, listOfRecords.get(i));
            }
        }
        return true;
    }

    private List<Date> buildAppraisalsDates(String[] line) throws PATException {
        List<Date> appraisalDates = new ArrayList<>();
        String DATE_FORMAT = "dd MMM yyyy";
        System.out.println("in data utility");
        for (int i = 7; i < line.length; i = i + 3) {
            if (line[7].equals("Rating April 2013")) {
                String duration = line[i].replaceFirst("Rating", "01");
                Date appraisalDate = DateUtility.stringToDate(duration, DATE_FORMAT);
                appraisalDates.add(appraisalDate);
            }
        }
        return appraisalDates;
    }

    private void buildAssociate(List<Date> appraisalsDateList, String[] line) throws PATException {
        String DATE_FORMAT = "dd-MMM-yy";
        AssociateDTO associateDTO = new AssociateDTO();
        associateDTO.setId(Integer.parseInt(line[0]));
        associateDTO.setFirstName(line[1]);
        associateDTO.setLastName(line[2]);
        associateDTO.setLocation(line[3]);
        Date doj = DateUtility.stringToDate(line[4], DATE_FORMAT);
        java.sql.Date sqlDate = new java.sql.Date(doj.getTime());
        associateDTO.setDateOfJoining(sqlDate);
        associateDTO.setCurrentGrade(line[5]);
        associateDTO.setReportingManager(Integer.parseInt(line[6]));
        associateDAO.saveOrUpdate(associateDTO);
        buildAppraisals(appraisalsDateList, line);
    }

    private void buildAppraisals(List<Date> appraisalDatesList, String[] line) throws PATException {

        int ratingIndex = 7;
        int salaryIndex = 8;
        int promotionIndex = 9;

        for (Date appraisalDate : appraisalDatesList) {

            if(line[ratingIndex] != null && line[ratingIndex].trim().length() != 0) {
                AppraisalDTO appraisalDTO = new AppraisalDTO();
                appraisalDTO.setId(Integer.parseInt(line[0]));
                appraisalDTO.setRatingPeriod(appraisalDate);
                appraisalDTO.setRating(Integer.parseInt(line[ratingIndex]));
                appraisalDTO.setSalary(Double.parseDouble(line[salaryIndex]));
                appraisalDTO.setPromotedTo(line[promotionIndex]);
                System.out.println(appraisalDTO);
                appraisalDAO.saveOrUpdate(appraisalDTO);
            }
            ratingIndex = ratingIndex + 3;
            salaryIndex = salaryIndex + 3;
            promotionIndex = promotionIndex + 3;
        }
    }
}
