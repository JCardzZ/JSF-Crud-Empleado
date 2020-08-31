/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Tbempleado;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author J Cardoza
 */
public class EmpleadoDaoImp implements EmpleadoDao {

    @Override
    public List<Tbempleado> mostrarEmpleados() {
        List<Tbempleado> listarEmpleados = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaccion = session.beginTransaction();

        String hql = "FROM Tbempleado as e inner join fetch e.tbpais left join fetch e.tbdepartamento left join fetch e.tbmunicipio";

        try {
            listarEmpleados = session.createQuery(hql).list();
            transaccion.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaccion.rollback();
        }

        return listarEmpleados;
    }

    @Override
    public void nuevoEmpleado(Tbempleado empleado) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(empleado);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.close();
            }
        }

    }
}
