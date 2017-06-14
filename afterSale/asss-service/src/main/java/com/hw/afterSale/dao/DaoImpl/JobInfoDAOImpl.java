package com.hw.afterSale.dao.DaoImpl;

import com.hw.afterSale.Constants.Constant;
import com.hw.afterSale.dao.JobInfoDAO;
import com.hw.afterSale.entity.JobInfo;
import com.thinvent.common.page.Page;
import com.thinvent.common.page.QueryParameter;
import com.hw.afterSale.Constants.HibernateDAO;
import com.thinvent.common.util.StringUtil;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangwei on 2017/5/15.
 */
@Repository
public class JobInfoDAOImpl extends HibernateDAO<JobInfo, String> implements JobInfoDAO{
    /**
     * 根据条件获取工单管理页面
     * @param condition
     * @return
     * @throws Exception
     */
    @Override
    public Page<JobInfo> getJobInfoPagesByCondition(QueryParameter queryParameter, Map<String, Object> condition) throws Exception {
        Map<String, Object> params = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String jobNo = (String)condition.get("jobNo");
        String startTime = (String)condition.get("startTime");
        String endTime = (String)condition.get("endTime");
        String answerPerson = (String)condition.get("answerPerson");
        String processPerson =(String)condition.get("processPerson");
        String processStatus = (String)condition.get("processStatus");
        String cmch = (String)condition.get("cmch");
        String processType = (String)condition.get("processType");
        String project = (String)condition.get("project");
        String lockOffice = (String)condition.get("lockOffice");
        StringBuffer hql = new StringBuffer();
        hql.append("  FROM JobInfo jobInfo where jobInfo.deletedFlag = :DELETED_FLAG");
        params.put("DELETED_FLAG", Constant.DELETED_FLAG_NO);
        if (!StringUtil.isNullOrEmpty(jobNo)) {
            hql.append(" AND jobInfo.jobNo = :jobNo");
            params.put("jobNo", jobNo);
        }
        if (!StringUtil.isNullOrEmpty(startTime)) {
            hql.append(" AND jonInfo.registraeDate >= :registraeDate1");
            params.put("registraeDate1",formatter.format(startTime));
        }
        if (!StringUtil.isNullOrEmpty(endTime)) {
            hql.append(" AND jobInfo.registraeDate <= :registraeDate2");
            params.put("registraeDate2", formatter.format(endTime));
        }
        if (!StringUtil.isNullOrEmpty(answerPerson)) {
            hql.append(" AND jobInfo.answerPerson = :answerPenson");
            params.put("answerPerson", answerPerson);
        }
        if (!StringUtil.isNullOrEmpty(processPerson)) {
            hql.append(" AND jobInfo.processPerson = :processPerson");
            params.put("processPerson",processPerson);
        }
        if (!StringUtil.isNullOrEmpty(processStatus)) {
            hql.append(" AND jobInfo.processStatus = :processStatus");
            params.put("processStatus", processStatus);
        }
        if (!StringUtil.isNullOrEmpty(processType)) {
            hql.append(" AND jobInfo.processType = :processType");
            params.put("processType", processType);
        }
        if (!StringUtil.isNullOrEmpty(cmch)) {
            hql.append(" AND jobInfo.cmch = :cmch");
            params.put("cmch",cmch);
        }
        if (!StringUtil.isNullOrEmpty(project)) {
            hql.append(" AND jobInfo.project.id =: id");
            params.put("id",project);
        }
        if (!StringUtil.isNullOrEmpty(lockOffice)) {
            hql.append(" AND jobInfo.lockOffice.id = :lockOffice");
            params.put("lockOffice", lockOffice);
        }
        return findPage(queryParameter,hql.toString(),params);
    }





}
