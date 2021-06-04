/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import java.util.List;
import model.Tbpais;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;
import dao.PaisDao;

/**
 *
 * @author sgrsm
 */
public class PaisDaoImpl implements PaisDao{

    @Override
    public List<Tbpais> listaPaises() {
        System.out.println("paisDaoImpl.listaPaises-0010");
        List<Tbpais> listarPaises = null;
        
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sesion.beginTransaction();
        
        String hql = "FROM Tbpais";
        
        try {
            System.out.println("paisDaoImpl.listaPaises-0020");
            listarPaises = sesion.createQuery(hql).list();
            System.out.println("paisDaoImpl.listaPaises-0030");
            t.commit();
            System.out.println("paisDaoImpl.listaPaises-0040");
            sesion.close();
            System.out.println("paisDaoImpl.listaPaises-0050");
        } catch (Exception e){
            System.out.println(e.getMessage());
            t.rollback();
        }
        
        /*sesion.beginTransaction();
        
        String hql = "FROM Tbpais";
        
        try {
            System.out.println("paisDaoImpl.listaPaises-0030");
            listarPaises = sesion.createQuery(hql).list();
            System.out.println("paisDaoImpl.listaPaises-0040");
            sesion.getTransaction().commit();
            System.out.println("paisDaoImpl.listaPaises-0050");
        } catch (Exception e) {
            System.out.println("paisDaoImpl.listaPaises-0060");
            System.out.println(e.getMessage());
            System.out.println("paisDaoImpl.listaPaises-0070");
            sesion.beginTransaction().rollback();
        } finally {
            sesion.close();
        }*/
        
        System.out.println("paisDaoImpl.listaPaises-0100");
        return listarPaises;
    }
    
}
