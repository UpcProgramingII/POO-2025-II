/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciocuentabancaria;

/**
 *
 * @author Jairo F
 */
public class CuentaBancaria {
    
    private Cliente titular;
    private double saldo;
    private static int id=0;
    
    public CuentaBancaria(){
            id++;
    }
    
    public CuentaBancaria(double saldo){
        id++;
        this.saldo=saldo;
    }
    
    public CuentaBancaria(double saldo, Cliente titular){
        this.saldo=saldo;
        this.titular=titular;
        id++;
    }
    
    public void setTitular(Cliente t){
        this.titular=t;
    }
    
    public void setSaldo(double s){
        this.saldo = s;
    }
    
    public Cliente getTitular(){
        return this.titular;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public void retirar(double monto){
        this.saldo -= monto;
    }
    
    public void depositar(double monto){
         this.saldo+=monto;
    }
    
    public void transferir(CuentaBancaria c){
        
        double monto = c.getSaldo();
        this.depositar(monto);
        c.retirar(monto);
        
    }
    
    public void mostrar(){
        System.out.println("titular: " + this.titular.obtenerDatos());
        System.out.println("saldo: " + this.saldo);
        
    }
    
    public static int getId(){
        return CuentaBancaria.id;
    }
}
