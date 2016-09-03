package com.cdk.pat.dao;


import com.cdk.pat.dto.AssociateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AssociateDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }


    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;

    }

    public AssociateDTO saveOrUpdate(AssociateDTO associateDTO){
        com.cdk.pat.domain.Associate domainAssociate = new com.cdk.pat.domain.Associate();
        domainAssociate.setId(associateDTO.getId());
        domainAssociate.setFirstName(associateDTO.getFirstName());
        domainAssociate.setLastName(associateDTO.getLastName());
        domainAssociate.setLocation(associateDTO.getLocation());
        domainAssociate.setDateOfJoining(associateDTO.getDateOfJoining());
        domainAssociate.setCurrentGrade(associateDTO.getCurrentGrade());
        domainAssociate.setReportingManager(associateDTO.getReportingManager());
        hibernateTemplate.save(domainAssociate);
        return associateDTO;
    }

    /*public List<AssociateDTO> getReportiesUnderManager(int managerId){
        System.out.println("in dao ");
        AssociateDTO associateDTO = null;
         List<com.cdk.pat.domain.Associate> domainAssociateList =  hibernateTemplate.findByNamedParam("from com.cdk.pat.domain.Associate a where a.reportingManager=:mID","mID",managerId);
        List<AssociateDTO> dtoAssociateList = null;
        System.out.println("fgyuh"+domainAssociateList.size());
        if(null != domainAssociateList && domainAssociateList.size() != 0){

            dtoAssociateList = new ArrayList<>();
            for(com.cdk.pat.domain.Associate a : domainAssociateList){
                associateDTO = new AssociateDTO();
                associateDTO.setId(a.getId());
                associateDTO.setFirstName(a.getFirstName());
                associateDTO.setLastName(a.getLastName());
                associateDTO.setLocation(a.getLocation());
                associateDTO.setDateOfJoining(a.getDateOfJoining());
                associateDTO.setCurrentGrade(a.getCurrentGrade());
                associateDTO.setDateOfJoining(a.getDateOfJoining());
                dtoAssociateList.add(associateDTO);
            }
        }
        return dtoAssociateList;
    }*/

}
