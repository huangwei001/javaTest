package com.hw.afterSale.service.Impl;


import com.hw.afterSale.dao.AnswerPersonDAO;
import com.hw.afterSale.entity.AnswerPerson;
import com.hw.afterSale.service.AnswerPersonService;
import com.thinvent.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

/**
 * Created by huangwei on 2017/5/15.
 */
@Service
public class AnswerPersonServicImpl extends BaseServiceImpl<AnswerPerson, String> implements AnswerPersonService {

    @Resource
    private AnswerPersonDAO answerPersonDao;



    /**
     * 保存处理人员
     * @return
     * @throws Exception
     */
    @Override
    public boolean saveAnswerPerson(Map<String, Object> params) throws Exception {
        String name = (String)params.get("name");
        String yhId = (String)params.get("yhId");
        AnswerPerson answerPerson = new AnswerPerson();
        answerPerson.setName(name);
        answerPerson.setYhId(yhId);
        answerPerson.setCreatedUserId(yhId);
        answerPerson.setCreatedTime(new Date());
        answerPerson.setDeletedFlag(0);
        answerPersonDao.save(answerPerson);
        return true;
    }


}
