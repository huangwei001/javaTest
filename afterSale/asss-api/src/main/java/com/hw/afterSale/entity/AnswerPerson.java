package com.hw.afterSale.entity;/*
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    : 接听人员实体
 * 做成日期    : 2017/5/15
 */


import com.thinvent.data.hibernate.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by huangwei on 2017/5/15.
 */
@Entity
@Table(name = "T_SHFWRY")
public class AnswerPerson extends BaseEntity{

    private String name;

    private String yhId;

    @Column(name = "NAME", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "YHID")
    public String getYhId() {
        return yhId;
    }

    public void setYhId(String yhId) {
        this.yhId = yhId;
    }
}
