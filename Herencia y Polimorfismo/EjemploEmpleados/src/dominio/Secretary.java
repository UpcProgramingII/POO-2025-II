/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Jairo F
 */
public class Secretary extends Employee {
    
    private double bonification;

    public Secretary(double bonification, String name, String id, double baseSalary) {
        super(name, id, baseSalary);
        this.bonification = bonification;
    }

    /**
     * @return the bonification
     */
    public double getBonification() {
        return bonification;
    }

    /**
     * @param bonification the bonification to set
     */
    public void setBonification(double bonification) {
        this.bonification = bonification;
    }

    @Override
    public void increaseSalary() {
        this.setBaseSalary(this.getBaseSalary()+this.bonification);
    }
    
    
    
    
}
