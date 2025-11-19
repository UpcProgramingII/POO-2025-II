/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examplecommand;

/**
 *
 * @author Jairo F
 */
public class ExampleCommand {

    public static void main(String[] args) {
        
        RemoteControl rc = new RemoteControl();
//        rc.On(new TVReceiver());
//        rc.On(new AIRReceiver());
//        
        GroupCommand gc = new GroupCommand();
        gc.addCommand(new OnCommand(new TVReceiver()));
        gc.addCommand(new OnCommand(new AIRReceiver()));
        
        
        rc.executeAutomatization(gc);
        
        
    }
}
