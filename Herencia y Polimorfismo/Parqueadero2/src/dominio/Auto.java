/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;


/**
 *
 * @author Jairo F
 */
public class Auto extends Vehiculo{
    
    
    private String marca;
    private int modelo;
    private  int nPuertas;

   

    public Auto(String placa, String marca, int modelo, int nPuertas) {
        super(placa);
        this.marca = marca;
        this.modelo = modelo;
        this.nPuertas = nPuertas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public int getnPuertas() {
        return nPuertas;
    }

    public void setnPuertas(int nPuertas) {
        this.nPuertas = nPuertas;
    }

    @Override
    public String toString() {
        return "Auto{"+ super.toString() +  ", marca=" + marca + ", modelo=" + modelo + ", nPuertas=" + nPuertas + ", costoParqueo=" + '}';
    }

    
    @Override
    public double facturar(double horas) {
        return horas * 2000;
    }
    
    
    
}
