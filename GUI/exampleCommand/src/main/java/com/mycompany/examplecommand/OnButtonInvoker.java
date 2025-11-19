/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examplecommand;

/**
 *
 * @author Jairo F
 */
public class OnButtonInvoker {
    
    private ControlCommand command;

    public OnButtonInvoker() {
    }

    /**
     * @param command the command to set
     */
    public void setCommand(ControlCommand command) {
        this.command = command;
    }
    
    public void On(){
        
        this.command.execute();
        
    }
    
}
