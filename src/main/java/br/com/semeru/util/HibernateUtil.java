/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.semeru.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 *
 * @author roberto
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    private static final String HIBERNATE_SESSION = "hibernate_session";
    
    static{
        try{
            System.out.println("Tentando abrir uma Session Factory");
            Configuration configuration = new Configuration().configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySetting(configuration.getProperty()).buildServiceRegistry();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            System.out.println("Session Factory criada com sucesso");
            
        } catch (HibernateException ex){
            System.out.println("Ocorreu um erro para iniciar Session Factory" + ex);
            throw new ExceptionInInitializerError(ex);
            
                    
        }
        
        
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
