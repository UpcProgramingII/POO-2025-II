/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Jairo F
 */
public class Vendor extends Employee{
    
    private double commission;

    public Vendor(double commission, String name, String id, double baseSalary) {
        super(name, id, baseSalary);
        this.commission = commission;
    }

    /**
     * @return the commission
     */
    public double getCommission() {
        return commission;
    }

    /**
     * @param commission the commission to set
     */
    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public void increaseSalary() {
        this.setBaseSalary(this.getBaseSalary()+this.commission);
    }
    
    public void metodoAdicional(){
    }
    
    
    
}
