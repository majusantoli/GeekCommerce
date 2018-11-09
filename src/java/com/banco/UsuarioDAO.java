/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banco;

import classes.Usuario;
import org.hibernate.*;
import org.hibernate.cfg.*;

/**
 *
 * @author profbrigadeiro
 */
public class UsuarioDAO {

    private SessionFactory factory;

    public UsuarioDAO() throws Exception {
        factory = HibernateUtil.getSessionFactory();

    }

    public void insert(Usuario aluno) throws Exception {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(aluno);
        tx.commit();
        session.close();
    }

    public Usuario retrieve(String pk) throws Exception {
        try {
        Session session = factory.openSession();
        Usuario aluno = (Usuario) session.get(Usuario.class, pk);
        session.flush();
        session.close();
        return aluno;
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public void delete(Usuario aluno) throws Exception {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(aluno);
        tx.commit();
        session.close();
    }

}
