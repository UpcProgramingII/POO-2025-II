/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dominio.Employee;

/**
 *
 * @author Jairo F
 */
public class EmployeeManager {
    
    
    public static void printEmployee(Employee employee){
    
        
        System.out.println("id: " + employee.getId());
        System.out.println("name: " + employee.getName());
        System.out.println("BaseSalary: " + employee.getBaseSalary());
        employee.increaseSalary();
        System.out.println("IncreaseBaseSalary: " + employee.getBaseSalary());
        
        
        
    }
    
    
    
}
