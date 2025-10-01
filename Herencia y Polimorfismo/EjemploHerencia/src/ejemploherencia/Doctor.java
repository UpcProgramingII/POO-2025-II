/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemploherencia;

/**
 *
 * @author Jairo F
 */
public class Doctor extends Person {
    
    private String specialty;
    private String hospital;

    public Doctor(int id, String name, String lastName, int age, 
            String specialty, String hospital) {
        super(id, name, lastName, age);
        this.specialty = specialty;
        this.hospital= hospital;
    }

    public String getSpecialty() {
        
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

   
    
    @Override
    public String toString() {
        return "Doctor{"+ super.toString()+"," + "specialty=" + specialty + ", hospital=" + hospital + '}';
    }
    
    
    
    
    
}
