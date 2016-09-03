package com.cdk.pat.dto;

import java.util.Date;

/**
 * Created by dullus on 9/2/2016.
 */
public class AppraisalDTO {
    private int sno;
    private int id;
    private Date ratingPeriod;
    private int rating;
    private double salary;
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

    @Override
    public String toString() {
        return "AppraisalDTO{" +
                "sno=" + sno +
                ", id=" + id +
                ", ratingPeriod=" + ratingPeriod +
                ", rating=" + rating +
                ", salary=" + salary +
                ", promotedTo='" + promotedTo + '\'' +
                '}';
    }
}
