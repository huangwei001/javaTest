package com.hw.afterSale.service.Impl;

import com.hw.afterSale.Constants.Constant;
import com.hw.afterSale.dao.AnswerPersonDAO;
import com.hw.afterSale.dao.JobInfoDAO;
import com.hw.afterSale.entity.AnswerPerson;
import com.hw.afterSale.entity.JobInfo;
import com.hw.afterSale.service.JobInfoService;


import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.thinvent.common.page.Page;
import com.thinvent.common.page.QueryParameter;
import com.thinvent.common.util.MapperUtil;
import com.thinvent.common.util.StringUtil;
import com.thinvent.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * Created by huangwei on 2017/5/15.
 */
@Service
public class JobInfoServiceImpl extends BaseServiceImpl<JobInfo, String> implements JobInfoService{

    @Autowired
    private JobInfoDAO jobInfoDAO;

    @Autowired
    private AnswerPersonDAO answerPersonDAO;
    /**
     * 根据条件获取工单管理页面
     * @param condition
     * @return
     * @throws Exception
     */
    @Override
    public String getJobInfoPageByCondition(QueryParameter queryParameter, Map<String, Object> condition,String...colums) throws Exception {
        Page<JobInfo> jobInfoPage = jobInfoDAO.getJobInfoPagesByCondition(queryParameter,condition);
        String result  = MapperUtil.convertToJson(jobInfoPage,colums);
        return result;
    }

    /**
     * 保存工单管理
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveJobInfo(Map<String, Object> params) throws Exception {

        String id = (String)params.get("id");

        String jobNo = (String)params.get("jobNo");

        String answerPersonId = (String)params.get("answerPerson");

        String processPerson =(String)params.get("processPerson");

        String processStatus = (String)params.get("processStatus");

        String cmch = (String)params.get("cmch");

        String processType = (String)params.get("processType");

        String project = (String)params.get("project");

        String lockOffice = (String)params.get("lockOffice");

        String sxy = (String)params.get("sxy");

        Date registraeDate = (Date)params.get("registraeDate");

        Date registraeMouth = (Date)params.get("registraeMouth");

        String phone = (String)params.get("phone");

        String question = (String)params.get("question");

        String remarks = (String)params.get("remarks");

        String userName = (String)params.get("userName");

        String userId = (String)params.get("userId");
        JobInfo jobInfo = null;
        if (!StringUtil.isNullOrEmpty(id)) {
            jobInfo = jobInfoDAO.get(id);
            jobInfo.setModifiedTime(new Date());
            jobInfo.setModifiedUserName(userName);
            jobInfo.setModifiedUserId(userId);
        }else {
            jobInfo.setCreatedTime(new Date());
            jobInfo.setCreatedUserId(userId);
            jobInfo.setCreatedUserName(userName);
        }

        AnswerPerson answerPerson = answerPersonDAO.get(answerPersonId);
        jobInfo.setAnswerPerson(answerPerson);
        jobInfo.setCmch(cmch);
        jobInfo.setJobNo(jobNo);
        jobInfo.setPhone(phone);

        jobInfo.setProcessPerson(answerPersonDAO.get(processPerson));
        jobInfo.setProcessStatus(processStatus);
        jobInfo.setQuestion(question);
        jobInfo.setSxy(sxy);
        jobInfo.setRegistraeDate(registraeDate);
        jobInfo.setRegistraeMouth(registraeMouth);
        jobInfo.setRemarks(remarks);
        jobInfo.setDeletedFlag(Constant.DELETED_FLAG_NO);
        jobInfoDAO.save(jobInfo);
        return true;
    }
}
