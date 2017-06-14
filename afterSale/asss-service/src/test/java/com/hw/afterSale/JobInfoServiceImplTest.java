package com.hw.afterSale;

import com.google.common.annotations.VisibleForTesting;
import com.hw.afterSale.service.JobInfoService;
import com.thinvent.common.page.QueryParameter;
import com.thinvent.common.util.MapperUtil;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangwei on 2017/5/15.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml",
        "classpath:service-provider-base.xml",
        "classpath:service-provider-dubbo.xml"
})
public class JobInfoServiceImplTest extends TestCase{

    @Resource
    private JobInfoService jobInfoService;

    @Test
    public void getJobInfoPages() throws Exception{
        QueryParameter queryParameter = new QueryParameter();
        Map<String, Object> condition = new HashMap<>();
        String[] colums = {"id"};
        String result = jobInfoService.getJobInfoPageByCondition(queryParameter,condition,colums);
        System.err.print(result);

    }





}
