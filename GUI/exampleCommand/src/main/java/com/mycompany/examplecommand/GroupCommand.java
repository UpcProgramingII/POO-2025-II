/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examplecommand;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class GroupCommand implements ControlCommand{
    
    private List<ControlCommand> comandList;

    public GroupCommand() {
        this.comandList= new ArrayList();
    }
    
    
    public void addCommand(ControlCommand command){
        this.comandList.add(command);
    }

    @Override
    public void execute() {
        this.comandList.forEach((t)->t.execute());
    }
    
}
