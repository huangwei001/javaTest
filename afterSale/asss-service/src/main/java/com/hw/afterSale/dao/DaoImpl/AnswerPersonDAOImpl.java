package com.hw.afterSale.dao.DaoImpl;

import com.hw.afterSale.dao.AnswerPersonDAO;
import com.hw.afterSale.entity.AnswerPerson;
import com.hw.afterSale.Constants.HibernateDAO;
import org.springframework.stereotype.Repository;

/**
 * Created by huangwei on 2017/5/15.
 */
@Repository
public class AnswerPersonDAOImpl extends HibernateDAO<AnswerPerson, String> implements AnswerPersonDAO {
}
