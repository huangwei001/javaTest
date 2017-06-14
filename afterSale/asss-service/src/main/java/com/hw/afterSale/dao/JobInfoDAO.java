package com.hw.afterSale.dao;

import com.hw.afterSale.entity.JobInfo;
import com.thinvent.common.page.Page;
import com.thinvent.common.page.QueryParameter;
import com.thinvent.data.hibernate.BaseDAO;

import java.util.Map;

/**
 * Created by huangwei on 2017/5/15.
 */

public interface JobInfoDAO extends BaseDAO<JobInfo, String> {

    /**
     * 根据条件获取工单管理页面
     * @param condition
     * @return
     * @throws Exception
     */
    Page<JobInfo> getJobInfoPagesByCondition(QueryParameter queryParameter, Map<String, Object> condition) throws Exception;


}
