package com.cdk.pat.domain;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "appraisal")
public class Appraisal {

    @Id
    @GeneratedValue
    @Column
    private int sno;
    @Column(name = "id")
    private int id;
    @Column(name = "ratingPeriod")
    private Date ratingPeriod;
    @Column(name = "rating")
    private int rating;
    @Column(name = "salary")
    private double salary;
    @Column(name = "promotedTo")
    private String promotedTo;

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRatingPeriod() {
        return ratingPeriod;
    }

    public void setRatingPeriod(Date ratingPeriod) {
        this.ratingPeriod = ratingPeriod;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPromotedTo() {
        return promotedTo;
    }

    public void setPromotedTo(String promotedTo) {
        this.promotedTo = promotedTo;
    }


}
