/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.Usuario;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jairo F
 */
public class DBUsuario {
    
    private Map<String, Usuario> usuariosDB;

    public DBUsuario() {
        this.usuariosDB = new HashMap();
    }
    
    public void registrarUsuario(Usuario u){
        this.usuariosDB.put(u.getUsername(), u);
    }
    
    public Usuario getUsuario(String username){
        
        Usuario u = null;
        u = this.usuariosDB.get(username);
        return u;    
    }
    
    public boolean usuarioExiste(String username){
        
        return this.usuariosDB.containsKey(username);
        
    }
    
    public int countUsuarios(){
        return this.usuariosDB.size();
    }
    
    
    
}
