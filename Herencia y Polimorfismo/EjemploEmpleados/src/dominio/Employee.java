/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Jairo F
 */
public abstract class Employee {
    
    private String name;
    private String id;
    private double baseSalary;

    public Employee() {
    }

    public Employee(String name, String id, double baseSalary) {
        this.name = name;
        this.id = id;
        this.baseSalary = baseSalary;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the baseSalary
     */
    public double getBaseSalary() {
        return baseSalary;
    }

    /**
     * @param baseSalary the baseSalary to set
     */
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
    
    public abstract void increaseSalary();
    
}
