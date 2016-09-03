package com.cdk.pat.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "associate")
public class Associate {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "location")
    private String location;
    @Column(name = "dateOfJoining")
    private Date dateOfJoining;
    @Column(name = "currentGrade")
    private String currentGrade;
    @Column(name = "reportingManager")
    private int reportingManager;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Appraisal> appraisal;

    public Set<Appraisal> getAppraisal() {
        return appraisal;
    }

    public void setAppraisal(Set<Appraisal> appraisal) {
        this.appraisal = appraisal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getCurrentGrade() {
        return currentGrade;
    }

    public void setCurrentGrade(String currentGrade) {
        this.currentGrade = currentGrade;
    }

    public int getReportingManager() {
        return reportingManager;
    }

    public void setReportingManager(int reportingManager) {
        this.reportingManager = reportingManager;
    }

}
