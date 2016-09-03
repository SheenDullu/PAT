package com.cdk.pat.controller;

import com.cdk.pat.dao.AppraisalDAO;
import com.cdk.pat.dao.AssociateDAO;
import com.cdk.pat.domain.Appraisal;
import com.cdk.pat.domain.Associate;
import com.cdk.pat.dto.AssociateDTO;
import com.cdk.pat.util.PATDataUtility;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/**
 * Created by dullus on 8/31/2016.
 */
@Controller
public class PATController {

    @Autowired
    private PATDataUtility patDataUtility = null;

    @Autowired
    private AssociateDAO associateDAO = null;

    @RequestMapping(value="/home")
    public String home(){
        return "home";
    }

    @RequestMapping(value = "/read", method = RequestMethod.POST)
    public
    @ResponseBody
    String read(HttpServletRequest request, HttpServletResponse response) {

        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload sf = new ServletFileUpload(diskFileItemFactory);
        System.out.println("heyyyyy");
        try {
            List<FileItem> fileItemList = sf.parseRequest(request);
            System.out.println("size  "+ fileItemList.size());
            if(null != fileItemList && fileItemList.size() == 1) {
                System.out.println("in controler");
                FileItem fileItem = fileItemList.get(0);
                String filePath =fileItem.getName();
                File file = new File(filePath);
                fileItem.write(file);
                patDataUtility.readLines(filePath);
            }
        }catch(Exception e) {
                return "Fails to read data from file, please validate data !!!";
        }
        return "Success";
    }
    @RequestMapping(value = "/getAppraisal",method = RequestMethod.GET)
    public
    @ResponseBody
    List<Appraisal> getAppraisal(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("eid"));
        AppraisalDAO appraisalDAO = new AppraisalDAO();
        return appraisalDAO.getAppraisalById(id);
    }

    @RequestMapping(value = "/getReportees",method = RequestMethod.GET)
    public
    @ResponseBody
    String getReportees(HttpServletRequest request, HttpServletResponse response){
        int managerId= Integer.parseInt(request.getParameter("id"));
        List<AssociateDTO> associateDTOList = associateDAO.getReportiesUnderManager(managerId);
       String string = "{ \"AssociateDTO\": [";
        for (AssociateDTO associateDTO : associateDTOList){
            string += "{\"id\": \"" + associateDTO.getId() +
                        "\", \"firstName\":\" " + associateDTO.getFirstName() + '\"' +
                        ", \"lastName\":\"" + associateDTO.getLastName() + '\"' +
                        ", \"location\":\"" + associateDTO.getLocation() + '\"' +
                        ", \"dateOfJoining\":\"" + associateDTO.getDateOfJoining() +
                        "\", \"currentGrade\":\"" + associateDTO.getCurrentGrade() + '\"' +
                        ", \"reportingManager\": \"" + associateDTO.getReportingManager() + '\"' +
                        "},";
        }
        string = string.substring(0,string.length()-1);
        string+="]}";
        return string;
    }
}

