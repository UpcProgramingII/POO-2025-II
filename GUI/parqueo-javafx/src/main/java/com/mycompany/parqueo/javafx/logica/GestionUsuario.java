/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.logica;

import com.mycompany.parqueo.javafx.datos.DBUsuario;
import com.mycompany.parqueo.javafx.dominio.Usuario;

/**
 *
 * @author Jairo F
 */
public class GestionUsuario {
    
    private DBUsuario db;

    public GestionUsuario() {
        this.db = new DBUsuario();
        
        this.registrarUsuario("Jairo", "Seoanes", "seuz", "12345");
        this.registrarUsuario("Luis", "Diaz", "lucho", "bayer");
        this.registrarUsuario("James", "Rodgiguez", "james", "10");
    }
    
    public Usuario crearUsuario(String nombre, String apellido, String username, String password){
        
        Usuario u = new Usuario(nombre, apellido, username, password);
        u.setId(this.db.countUsuarios()+1);
        return u;
        
    }
    
    public void registrarUsuario(Usuario u){
        this.db.registrarUsuario(u);
    }
    
    public void registrarUsuario(String nombre, String apellido, String username, String password){
        Usuario u = this.crearUsuario(nombre, apellido, username, password);
        this.registrarUsuario(u);
    }
    
    public Usuario login(String username, String password){
        
        Usuario u = this.db.getUsuario(username);
        if(u!=null){
            if(u.getPassword().equals(password)){
                return u;
            }else{
                System.out.println("!! Contraseña no valida ¡¡");
                return null;
            }
        }else{
            System.out.println(" !! EL usuario no esta registrado ¡¡");
            return null;
        }
        
    }
    
    
    
    
}
