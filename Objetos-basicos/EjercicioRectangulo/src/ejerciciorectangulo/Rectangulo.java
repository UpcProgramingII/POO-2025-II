/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciorectangulo;

/**
 *
 * @author Jairo F
 */
public class Rectangulo {
    
    private double base;
    private double altura;
    
    public Rectangulo(){
        this.base=5;
        this.altura=10;
    }
    
    public void setBase(double base){
        this.base = base;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getBase(){
        return this.base;
    }
    
    public double getAltura(){
        return this.altura;
    }
    
    public double calcularArea(){
        
        return this.base * this.altura;
        
    }
    
    public double calcularPerimetro(){
        return 2 *(this.base + this.altura);
    }
    
}
