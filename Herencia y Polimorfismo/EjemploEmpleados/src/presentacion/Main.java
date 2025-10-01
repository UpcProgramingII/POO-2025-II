/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import dominio.Employee;
import dominio.Vendor;
import dominio.ZoneBoss;
import logica.EmployeeManager;

/**
 *
 * @author Jairo F
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Employee vendor = new ZoneBoss(500, 100, "Jairo", "123", 500);
        EmployeeManager.printEmployee(vendor);
    }
    
}
