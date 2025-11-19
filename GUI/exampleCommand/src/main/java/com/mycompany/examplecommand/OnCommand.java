/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examplecommand;

/**
 *
 * @author Jairo F
 */
public class OnCommand implements ControlCommand {
    
    private Receivers receiver;

    public OnCommand(Receivers receiver) {
        this.receiver = receiver;
    }
    
    @Override
    public void execute() {
        
        this.receiver.encender();
        
        
    }
    
}
