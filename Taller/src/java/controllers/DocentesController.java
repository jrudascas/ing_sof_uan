/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Docentes;

/**
 *
 * @author jrudascas
 */
public class DocentesController {

    Session session = null;
    Transaction transaction = null;

    public List<Docentes> list() throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Query q = session.createQuery("from Docentes");
            return (List<Docentes>) q.list();
        } catch (Exception e) {
            throw new Exception("Imposible lista los Docentes");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void create(Docentes docentes) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(docentes);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw new Exception("Imposible crear el docente");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(String idDocentes) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.delete(idDocentes, Docentes.class);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Imposible eliminar el docente");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Docentes docentes) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.update(docentes);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Imposible actualizar el docente");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
