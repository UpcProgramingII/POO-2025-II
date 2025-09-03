/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciocuentabancaria;

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
        
        Cliente cliente = new Cliente("carlos", "javier");
        CuentaBancaria a = new CuentaBancaria(100, cliente);
        
        CuentaBancaria b = new CuentaBancaria(500);
        b.setTitular(cliente);
        
        CuentaBancaria c = new CuentaBancaria();
        c.setSaldo(300);
        c.setTitular(cliente);
        
        
        a.depositar(500);
        b.retirar(50);
        a.transferir(b);
        
        a.mostrar();
        b.mostrar();
        
        System.out.println("No cuentas: "+CuentaBancaria.getId());
    }
    
}
