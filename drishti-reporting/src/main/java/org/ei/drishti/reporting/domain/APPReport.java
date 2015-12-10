/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ei.drishti.reporting.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "app_reporting")

//@NamedQuery(name = APPReport.FIND_BY_ENTITY_ID,
//        query = "select w from APPReport w where w.entityid=:entityid")
public class APPReport {

    //Date date=new Date();

    //public static final String FIND_BY_ENTITY_ID = "find.by.entity.id";

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "visitentityid")
    private String visitentityid;

    @Column(name = "entityidec")
    private String entityidec;

    @Column(name = "patient_name")
    private String patient_name;

    @Column(name = "anm_id")
    private String anm_id;

    @Column(name = "activity")
    private String activity;

    @Column(name = "indicator")
    private String indicator;

    @Column(name = "indicator_count")
    private Integer indicator_count;

    @Column(name = "date")
    private String date;

    @Column(name = "location")
    private String location;

    @Column(name = "child_weight")
    private Integer child_weight;

    @Column(name = "other_date")
    private String other_date;

    @Column(name = "visit_location")
    private String visit_location;
    
    @Column(name = "dob")
    private String dob;

    private APPReport() {
    }

    public APPReport(String visitentityid, String entityidec, String patient_name, String anm_id, String activity, String indicator, Integer indicator_count, String date, String location, Integer child_weight, String other_date, String visit_location, String dob) {
        this.visitentityid = visitentityid;
        this.entityidec = entityidec;
        this.patient_name = patient_name;
        this.anm_id = anm_id;
        this.activity = activity;
        this.indicator = indicator;
        this.indicator_count = indicator_count;
        this.date = date;
        this.location = location;
        this.child_weight = child_weight;
        this.other_date = other_date;
        this.visit_location = visit_location;
        this.dob=dob;

    }

    public Integer id() {
        return id;
    }

    public String visitentityid() {
        return visitentityid;
    }

    public String entityidec() {
        return entityidec;
    }

    public String patient_name() {
        return patient_name;
    }


    public String anm_id() {
        return anm_id;
    }

    public String activity() {
        return activity;
    }

    public String indicator() {
        return indicator;
    }



    public Integer indicator_count() {
        return indicator_count;
    }


    public String date() {
        return date;
    }

    public String location() {
        return location;
    }

    public Integer child_weight() {
        return child_weight;
    }

    public String other_date() {
        return other_date;
    }

    public String visit_location() {
        return visit_location;
    }
    public String dob() {
        return dob;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o, new String[]{"id"});
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, new String[]{"id"});
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
