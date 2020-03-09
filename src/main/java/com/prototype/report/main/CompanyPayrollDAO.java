package com.prototype.report.main;

import com.prototype.report.entities.Employees;
import com.prototype.report.management.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CompanyPayrollDAO<T extends Serializable> {
    public List<T> fetchByCustomQuery(String stringQuery){
        Session session = null;
        List<T> list = new ArrayList<>();
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            NativeQuery<T> query = session.createSQLQuery(stringQuery).addEntity(Employees.class);
            list = query.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            assert session != null;
            session.close();
        }
        return list;
    }
}
