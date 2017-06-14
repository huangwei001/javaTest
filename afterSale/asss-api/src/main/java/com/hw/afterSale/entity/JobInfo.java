package com.hw.afterSale.entity;/*
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    : 工单基本信息实体
 * 做成日期    : 2017/5/15
 */

import com.thinvent.data.hibernate.BaseEntity;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.Date;

/**
 * created by huangwei
 * @date 2017-5-15
 */
@Entity
@Table(name = "T_GDJBXX")
public class JobInfo extends BaseEntity {


    private AnswerPerson answerPerson;

    private String Phone;

    private Date registraeDate;

    private Date registraeMouth;

    private Dictionary project;

    private Dictionary lockOffice;

    private String cmch;

    private String sxy;

    private String question;

    private String remarks;

    private String jobNo;

    private AnswerPerson processPerson;

    private String processStatus;

    private Dictionary processType;

    private Date questionDate;

    @OneToOne
    @JoinColumn(name = "answerPerson", referencedColumnName = "id", nullable = true)
    public AnswerPerson getAnswerPerson() {
        return answerPerson;
    }

    public void setAnswerPerson(AnswerPerson answerPerson) {
        this.answerPerson = answerPerson;
    }

    @Column(name = "LXDH")
    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Column(name = "DJRQ")
    public Date getRegistraeDate() {
        return registraeDate;
    }

    public void setRegistraeDate(Date registraeDate) {
        this.registraeDate = registraeDate;
    }

    @Column(name = "DJYF")
    public Date getRegistraeMouth() {
        return registraeMouth;
    }

    public void setRegistraeMouth(Date registraeMouth) {
        this.registraeMouth = registraeMouth;
    }

    @OneToOne
    @JoinColumn(name = "SSXM", referencedColumnName = "id", nullable = true)
    public Dictionary getProject() {
        return project;
    }

    public void setProject(Dictionary project) {
        this.project = project;
    }

    @OneToOne
    @JoinColumn(name = "CZS", referencedColumnName = "id")
    public Dictionary getLockOffice() {
        return lockOffice;
    }

    public void setLockOffice(Dictionary lockOffice) {
        this.lockOffice = lockOffice;
    }

    @Column(name = "CMCH")
    public String getCmch() {
        return cmch;
    }

    public void setCmch(String cmch) {
        this.cmch = cmch;
    }

    @Column(name = "SXY")
    public String getSxy() {
        return sxy;
    }

    public void setSxy(String sxy) {
        this.sxy = sxy;
    }

    @Column(name = "WT", nullable = true)
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Column(name = "BZ")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Column(name = "GDH")
    public String getJobNo() {
        return jobNo;
    }

    public void setJobNo(String jobNo) {
        this.jobNo = jobNo;
    }

    @OneToOne
    @JoinColumn(name = "CLRY", referencedColumnName = "id")
    public AnswerPerson getProcessPerson() {
        return processPerson;
    }

    public void setProcessPerson(AnswerPerson processPerson) {
        this.processPerson = processPerson;
    }

    @Column(name = "CLZT")
    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    @OneToOne
    @JoinColumn(name = "CLLX", referencedColumnName = "id")
    public Dictionary getProcessType() {
        return processType;
    }

    public void setProcessType(Dictionary processType) {
        this.processType = processType;
    }

    @Column(name = "WTFSRQ")
    public Date getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(Date questionDate) {
        this.questionDate = questionDate;
    }












}
