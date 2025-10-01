/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

/**
 *
 * @author Jairo F
 */
public class ZoneBoss extends Employee {
    
    private double gastosRepresentacion;
    private double primaCumplimiento;

    public ZoneBoss(double gastosRepresentacion, double primaCumplimiento, String name, String id, double baseSalary) {
        super(name, id, baseSalary);
        this.gastosRepresentacion = gastosRepresentacion;
        this.primaCumplimiento = primaCumplimiento;
    }

    /**
     * @return the gastosRepresentacion
     */
    public double getGastosRepresentacion() {
        return gastosRepresentacion;
    }

    /**
     * @param gastosRepresentacion the gastosRepresentacion to set
     */
    public void setGastosRepresentacion(double gastosRepresentacion) {
        this.gastosRepresentacion = gastosRepresentacion;
    }

    /**
     * @return the primaCumplimiento
     */
    public double getPrimaCumplimiento() {
        return primaCumplimiento;
    }

    /**
     * @param primaCumplimiento the primaCumplimiento to set
     */
    public void setPrimaCumplimiento(double primaCumplimiento) {
        this.primaCumplimiento = primaCumplimiento;
    }

    @Override
    public void increaseSalary() {
        
         this.setBaseSalary(this.getBaseSalary() + this.gastosRepresentacion + this.primaCumplimiento);
         
    }
    
    
}
