/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImp;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.Tbempleado;

/**
 *
 * @author J Cardoza
 */
@Named(value = "empleadoBean")
@ViewScoped
public class EmpleadoBean implements Serializable{

    /**
     * Creates a new instance of EmpleadoBean
     */
    private List<Tbempleado> listar;
    private Tbempleado empleado;
    
    
    public EmpleadoBean() {
    }

    public Tbempleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Tbempleado empleado) {
        this.empleado = empleado;
    }

    public List<Tbempleado> getListar() {
        EmpleadoDao eDao = new EmpleadoDaoImp();
        listar = eDao.mostrarEmpleados();
        return listar;
    }

    public void nuevoEmpleado(){
        EmpleadoDao eDao = new EmpleadoDaoImp();
        eDao.nuevoEmpleado(empleado);
        empleado = new Tbempleado();
    }

}
