package com.hw.afterSale.entity;/*
 * Copyright (C) 2017 南京思创信息技术有限公司
 * <p>
 * 版权所有。
 * <p>
 * 功能概要    : 字典实体
 * 做成日期    : 2017/5/15
 */
import com.thinvent.data.hibernate.BaseEntity;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Created by huangwei on 2017/5/15.
 */
public class Dictionary extends BaseEntity {

    private String zdnr;

    private String xtzdk;

    private String sfxtzd;

    private String zdsm;

    private Dictionary sjzd;

    private int zdpx;

    private String sfry;

    @Column(name = "ZDNR", nullable = true)
    public String getZdnr() {
        return zdnr;
    }

    public void setZdnr(String zdnr) {
        this.zdnr = zdnr;
    }

    @Column(name = "XTZDK")
    public String getXtzdk() {
        return xtzdk;
    }

    public void setXtzdk(String xtzdk) {
        this.xtzdk = xtzdk;
    }

    @Column(name = "SFXTZD", nullable = true)
    public String getSfxtzd() {
        return sfxtzd;
    }

    public void setSfxtzd(String sfxtzd) {
        this.sfxtzd = sfxtzd;
    }

    @Column(name = "ZDSM")
    public String getZdsm() {
        return zdsm;
    }

    public void setZdsm(String zdsm) {
        this.zdsm = zdsm;
    }

    @OneToOne
    @JoinColumn(name = "SJZD", referencedColumnName = "id")
    public Dictionary getSjzd() {
        return sjzd;
    }

    public void setSjzd(Dictionary sjzd) {
        this.sjzd = sjzd;
    }

    @Column(name = "ZDPX",nullable = true)
    public int getZdpx() {
        return zdpx;
    }

    public void setZdpx(int zdpx) {
        this.zdpx = zdpx;
    }

    @Column(name = "SFRY", nullable = true)
    public String getSfry() {
        return sfry;
    }

    public void setSfry(String sfry) {
        this.sfry = sfry;
    }
}
