/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examplecommand;

/**
 *
 * @author Jairo F
 */
public class AIRReceiver implements Receivers {
    
    private boolean estado; // true-on ,  false_off
    private int temperatura;
    

    @Override
    public void encender() {
        this.estado=true;
        System.out.println("El aire esta encendido");

    }

    @Override
    public void configurar() {
        this.temperatura=19;
    }

    @Override
    public void apagar() {
        this.estado=false;
        System.out.println("El aire esta apagado");
    }
    
}
