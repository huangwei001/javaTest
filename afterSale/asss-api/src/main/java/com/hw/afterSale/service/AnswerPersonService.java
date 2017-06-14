package com.hw.afterSale.service;

import com.alibaba.fastjson.JSONObject;
import com.hw.afterSale.entity.AnswerPerson;
import com.thinvent.service.BaseService;

import java.util.Map;

/**
 * Created by huangwei on 2017/5/15.
 */
public interface AnswerPersonService extends BaseService<AnswerPerson, String> {

    /**
     * 保存处理人员
     * @return
     * @throws Exception
     */
    boolean saveAnswerPerson(Map<String, Object> params) throws Exception;



}
