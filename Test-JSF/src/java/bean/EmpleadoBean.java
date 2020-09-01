/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EmpleadoDao;
import dao.EmpleadoDaoImp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
        empleado = new Tbempleado();
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
    
    public void cancelar(){
        empleado = new Tbempleado();
    }

}
