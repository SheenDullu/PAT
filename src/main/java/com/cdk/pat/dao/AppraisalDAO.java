package com.cdk.pat.dao;

import com.cdk.pat.domain.Appraisal;
import com.cdk.pat.dto.AppraisalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppraisalDAO {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
        this.hibernateTemplate.setAllowCreate(true);
    }

    public AppraisalDTO saveOrUpdate(AppraisalDTO appraisalDTO){
        com.cdk.pat.domain.Appraisal domainAppraisal = new com.cdk.pat.domain.Appraisal();
        domainAppraisal.setId(appraisalDTO.getId());
        domainAppraisal.setRatingPeriod(new java.sql.Date(appraisalDTO.getRatingPeriod().getTime()));
        domainAppraisal.setRating(appraisalDTO.getRating());
        domainAppraisal.setSalary(appraisalDTO.getSalary());
        domainAppraisal.setPromotedTo(appraisalDTO.getPromotedTo());
        hibernateTemplate.save(domainAppraisal);
        appraisalDTO.setSno(domainAppraisal.getSno());
        return appraisalDTO;
    }

    public List<Appraisal> getAppraisalById(int id){
        return (List<Appraisal>)hibernateTemplate.findByNamedParam("from com.cdk.pat.domain.Appraisal a where  a.id=:aid", "aid", id);
    }


}
