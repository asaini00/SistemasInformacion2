/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.SSII2.entity;

/**
 *
 * @author Alvaro
 */
public class WorkersID {
    
    String nombre ;
    String apellido1;
    String apellido2;
    String empresa;
    String email;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getEmail() {
        return email;
    }
    

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
}
