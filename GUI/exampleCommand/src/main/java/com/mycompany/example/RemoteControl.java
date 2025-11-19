/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.example;

/**
 *
 * @author Jairo F
 */
public class RemoteControl {

    private Receivers receiver;
    
    public RemoteControl() {
    }
    
    public void setReceiver(Receivers receviver){
        
        this.receiver = receiver;
        
    }
    
    public void OnButton(){
        
        this.receiver.encender();
        
    }
    
    public void OffButton(){
        this.receiver.apagar();
    }
    
    
    public void function(){
    
        
    }   
    
    
}
