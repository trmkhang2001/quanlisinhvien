/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.List;
import model.Sinhvien;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author jclov
 */
public class SinhVienDao implements DAO<Sinhvien>{
    @Override
    public List<Sinhvien> findAll() {
        List<Sinhvien> list=null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            list=sess.createCriteria(Sinhvien.class).list();
                    
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            sess.close();
        }
        return list;
    }

    @Override
    public Sinhvien findById(Serializable id) {
        Sinhvien da=null;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            da=(Sinhvien) sess.get(Sinhvien.class, id);
                    
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            sess.close();
        }
        return da;
    }

    @Override
    public boolean insert(Sinhvien t) {
       boolean flag=false;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.save(t);
                    
            tx.commit();
            flag=true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            sess.close();
        }
        return flag;
    }

    @Override
    public boolean delete(Serializable id) {
        boolean flag=false;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            Sinhvien da=(Sinhvien) sess.get(Sinhvien.class, id);
            sess.delete(da);
                    
            tx.commit();
            flag=true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            sess.close();
        }
        return flag;
    }

    @Override
    public boolean update(Sinhvien t) {
        boolean flag=false;
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session sess = sf.openSession();
        Transaction tx = null;
        try {
            tx = sess.beginTransaction();
            sess.saveOrUpdate(t);
                    
            tx.commit();
            flag=true;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            sess.close();
        }
        return flag;
    }
}
