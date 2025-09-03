/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciorectangulo;

/**
 *
 * @author Jairo F
 */
public class Ppal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Rectangulo a = new Rectangulo();
        imprimirRectangulo(a);
        
        
        
     }
    
     public static void imprimirRectangulo(Rectangulo r){
         
         System.out.printf("base: %.2f , altura: %.2f, Area: %.2f, Perimetro: %.2f%n", 
                r.getBase(), 
                r.getAltura(), 
                r.calcularArea(),
                r.calcularPerimetro());
         
     }
    
    
}
