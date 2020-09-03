/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImp;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import model.Tbdepartamento;
import model.Tbempleado;
import model.Tbmunicipio;
import model.Tbpais;

/**
 *
 * @author J Cardoza
 */
@Named(value = "empleadoBean")
@ViewScoped
public class EmpleadoBean implements Serializable {

    /**
     * Creates a new instance of EmpleadoBean
     */
    private List<Tbempleado> listar;
    private Tbempleado empleado;
    private List<SelectItem> listarPaises;
    private List<SelectItem> listarDepartamentos;
    private List<SelectItem> listarMunicipios;

    public EmpleadoBean() {
        empleado = new Tbempleado();
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

    public void nuevoEmpleado() {
        EmpleadoDao eDao = new EmpleadoDaoImp();
        eDao.nuevoEmpleado(empleado);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se guardo correctamente"));

        empleado = new Tbempleado();
    }

    public void prepararNuevoEmpleado(ActionEvent actionEven) {
        empleado = new Tbempleado();
    }

    public void modificarEmpleado() {
        EmpleadoDao eDao = new EmpleadoDaoImp();
        eDao.modificarEmpleado(empleado);
        empleado = new Tbempleado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se actualizazo  correctamente"));

    }

    public void eliminarEmpleado() {
        EmpleadoDao eDao = new EmpleadoDaoImp();
        eDao.eliminarEmpleado(empleado);
        empleado = new Tbempleado();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "El registro se elimino correctamente"));

    }

    public List<SelectItem> getListarPaises() {
        this.listarPaises = new ArrayList<SelectItem>();
        EmpleadoDao eDao = new EmpleadoDaoImp();
        List<Tbpais> p = eDao.listarPaises();
        listarPaises.clear();
        for (Tbpais pais : p) {
            SelectItem paisItem = new SelectItem(pais.getIdPais(), pais.getNombrePais());
            this.listarPaises.add(paisItem);
        }
        return listarPaises;
    }

    public List<SelectItem> getListarDepartamentos() {
        this.listarDepartamentos = new ArrayList<SelectItem>();
        EmpleadoDao eDao = new EmpleadoDaoImp();
        List<Tbdepartamento> d = eDao.listarDepartamentos(empleado);
        listarDepartamentos.clear();
        for (Tbdepartamento dpto : d) {
            SelectItem dptoItem = new SelectItem(dpto.getIdDepartamento(), dpto.getNombreDepartamento());
            this.listarDepartamentos.add(dptoItem);
        }
        return listarDepartamentos;
    }

    public List<SelectItem> getListarMunicipios() {
        this.listarMunicipios = new ArrayList<SelectItem>();
        EmpleadoDao eDao = new EmpleadoDaoImp();
        List<Tbmunicipio> m = eDao.listarMunicipios(empleado);
        listarMunicipios.clear();
        for (Tbmunicipio muni : m) {
            SelectItem muniItem = new SelectItem(muni.getIdMunicipio(), muni.getNombreMunicipio());
            this.listarMunicipios.add(muniItem);
        }
        return listarMunicipios;
    }

    public void cancelar() {
        empleado = new Tbempleado();
    }

}
