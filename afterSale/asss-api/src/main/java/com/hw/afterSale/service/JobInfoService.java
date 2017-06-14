package com.hw.afterSale.service;

import com.hw.afterSale.entity.JobInfo;
import com.thinvent.common.page.QueryParameter;
import com.thinvent.service.BaseService;

import java.util.Map;

/**
 * Created by huangwei on 2017/5/15.
 */
public interface JobInfoService extends BaseService<JobInfo, String> {

    /**
     * 根据条件获取工单管理页面
     * @param condition
     * @return
     * @throws Exception
     */
    String getJobInfoPageByCondition(QueryParameter queryParameter, Map<String, Object> condition, String...colums) throws Exception;

    /**
     * 保存工单管理
     * @return
     * @throws Exception
     */
    boolean saveJobInfo(Map<String, Object> params) throws Exception;
}
