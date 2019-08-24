/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojos.Estudiantes;

/**
 *
 * @author jrudascas
 */
public class EstudiantesController {

    Session session = null;
    Transaction transaction = null;

    public List<Estudiantes> list() throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            Query q = session.createQuery("from Estudiantes");
            return (List<Estudiantes>) q.list();
        } catch (Exception e) {
            throw new Exception("Imposible lista los estudiante");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Estudiantes getById(Integer idEstudiante) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();
        Estudiantes estudiante = null;
        try {
            estudiante = (Estudiantes) session.load(Estudiantes.class, idEstudiante);
            int id = estudiante.getIdEstudiantes();
            String nombres = estudiante.getNombres();
            System.out.print(id);
        } catch (Exception e) {
            throw new Exception("Imposible encontrar el estudiante");
        } finally {
            if (session != null) {
                session.close();
            }
        }
        
        return estudiante;
    }

    public void create(Estudiantes estudiante) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.save(estudiante);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
                throw new Exception("Imposible crear el estudiante");
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void delete(Integer idEstudiante) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            Estudiantes estudiante = (Estudiantes) session.load(Estudiantes.class, idEstudiante);
            session.delete(estudiante);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Imposible eliminar el estudiante");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void update(Estudiantes estudiante) throws Exception {
        session = settings.NewHibernateUtil.getSessionFactory().openSession();

        try {
            transaction = session.beginTransaction();
            session.update(estudiante);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception("Imposible actualizar el estudiante");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
