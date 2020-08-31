/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Tbempleado;

/**
 *
 * @author J Cardoza
 */
public interface EmpleadoDao {
    
    public List<Tbempleado> mostrarEmpleados();
    
    public void nuevoEmpleado (Tbempleado empleado);
}
