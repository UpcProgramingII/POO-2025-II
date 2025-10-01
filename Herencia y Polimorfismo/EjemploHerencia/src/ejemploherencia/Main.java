/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploherencia;

import java.util.ArrayList;

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
        
        Person jairo = new Person(123, "Jairo", "Seoanes", 25);
        
        Doctor byter = new Doctor(123, "Jairo", "Seoanes", 25, "Bacteriolog", "HEAD VPar");
        
        
        ArrayList<Person> lista = new ArrayList();
        lista.add(jairo);
        imprimirLista(lista);
        
        
    }
    
    public static void imprimirLista(ArrayList<Person> lista){
        for(Person p : lista){
            System.out.println(p);
        }
    }
    
}
