package com.hw.afterSale.entity;/*
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    : 售后服务附件实体
 * 做成日期    : 2017/5/15
 */
import com.strongit.nj.bis.entity.TFile;
import com.thinvent.data.hibernate.BaseEntity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by huangwei on 2017/5/15.
 */
public class Enclosure extends BaseEntity {

    private JobInfo jobInfo;

    private TFile fjId;

    @OneToOne
    @JoinColumn(name = "GDJBXX", referencedColumnName = "id", nullable = true)
    public JobInfo getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(JobInfo jobInfo) {
        this.jobInfo = jobInfo;
    }

    @OneToOne
    @JoinColumn(name = "FJID", referencedColumnName = "id", nullable = true)
    public TFile getFjId() {
        return fjId;
    }

    public void setFjId(TFile fjId) {
        this.fjId = fjId;
    }
}
