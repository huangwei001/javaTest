package com.hw.afterSale;

import com.hw.afterSale.Constants.Constant;
import com.hw.afterSale.Constants.Technique;
import com.hw.afterSale.service.AnswerPersonService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class AnswerPersonServiceImplTest extends TestCase {

    @Resource
    private AnswerPersonService answerPersonService;


    @Test
    public void saveAnswerPerson() throws Exception {

        Map<String, Object> params = new HashMap<>();
        params.put("name","huangwei");
        params.put("yhId","1");
        boolean result = answerPersonService.saveAnswerPerson(params);
    }


    @Test
    public void test1()throws Exception{
        Map<String, Object> params = new HashMap<>();
        params.put("name","huangwei");
        params.put("yhId",null);
//        params.get(params.keySet()).toString();

        /*System.err.print();*/


    }
}
