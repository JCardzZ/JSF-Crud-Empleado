/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Tbdepartamento;
import model.Tbempleado;
import model.Tbmunicipio;
import model.Tbpais;

/**
 *
 * @author J Cardoza
 */
public interface EmpleadoDao {

    public List<Tbempleado> mostrarEmpleados();

    public void modificarEmpleado(Tbempleado empleado);

    public void eliminarEmpleado(Tbempleado empleado);

    public void nuevoEmpleado(Tbempleado empleado);

    public List<Tbpais> listarPaises();

    public List<Tbdepartamento> listarDepartamentos(Tbempleado empleado);

    public List<Tbmunicipio> listarMunicipios(Tbempleado empleado);

}
