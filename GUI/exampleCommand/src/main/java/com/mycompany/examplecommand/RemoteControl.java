/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examplecommand;

import java.util.List;

/**
 *
 * @author Jairo F
 */
public class RemoteControl {
    
    private OnButtonInvoker onButton;
    
    public RemoteControl() {
        this.onButton = new OnButtonInvoker();
    }
    
    public void On(Receivers receiver){
        
        OnCommand on=new OnCommand(receiver);
        this.onButton.setCommand(on);
        this.onButton.On();
        
    }
    
    public void executeAutomatization(GroupCommand g){
        
        g.execute();
    
    }
    
    
    
}
