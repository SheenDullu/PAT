package com.cdk.pat.dto;

import java.sql.Date;

/**
 * Created by dullus on 9/2/2016.
 */
public class AssociateDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String location;
    private Date dateOfJoining;
    private String currentGrade;
    private int reportingManager;

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

    @Override
    public String toString() {
        return "AssociateDTO{" +
                "id=" + id +
                ", firstName:'" + firstName + '\'' +
                ", lastName:'" + lastName + '\'' +
                ", location:'" + location + '\'' +
                ", dateOfJoining:'" + dateOfJoining +
                "', currentGrade:'" + currentGrade + '\'' +
                ", reportingManager:" + reportingManager +
                '}';
    }
}
