package com.hw.afterSale.entity;/*
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    : 工单信息处理实体
 * 做成日期    : 2017/5/15
 */
import com.thinvent.data.hibernate.BaseEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by huangwei on 2017/5/15.
 */
public class JobInfoProcess extends BaseEntity{

    private JobInfo jobInfo;

    private String processStatus;

    private String reason;

    private Dictionary processType;

    private AnswerPerson processPerson;

    private String processPlan;


    @OneToOne
    @JoinColumn(name = "GDJBXX", referencedColumnName = "id",nullable = true)
    public JobInfo getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(JobInfo jobInfo) {
        this.jobInfo = jobInfo;
    }

    @Column(name = "CLZT", nullable = true)
    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    @Column(name = "QXYY")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @OneToOne
    @JoinColumn(name = "CLLX", referencedColumnName = "id")
    public Dictionary getProcessType() {
        return processType;
    }

    public void setProcessType(Dictionary processType) {
        this.processType = processType;
    }

    @OneToOne
    @JoinColumn(name = "CLRY", referencedColumnName = "id", nullable = true)
    public AnswerPerson getProcessPerson() {
        return processPerson;
    }

    public void setProcessPerson(AnswerPerson processPerson) {
        this.processPerson = processPerson;
    }

    @Column(name = "CLFA")
    public String getProcessPlan() {
        return processPlan;
    }

    public void setProcessPlan(String processPlan) {
        this.processPlan = processPlan;
    }
}
