/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.RegistroParking;
import com.mycompany.parqueo.javafx.excepciones.ArchivoException;
import java.io.*;
import java.util.List;

/**
 *
 * @author Jairo F
 */
public class ArchivoParking implements IBDRegistroParking {

    private File archivo;
    private FileInputStream aLectura;
    private FileOutputStream aEscritura;

    public ArchivoParking() throws ArchivoException {

        this.archivo = new File("BDParking.obj");
        try {
            if (!this.archivo.exists()) {
                this.archivo.createNewFile();
                this.guardar(new ListRegistroParking());
            }
        } catch (IOException e) {
            throw new ArchivoException("Error al crear archivo de Parking");
        }
    }

    private IBDRegistroParking leer() throws ArchivoException {
        ObjectInputStream ois = null;
        try {
            this.aLectura = new FileInputStream(this.archivo);
            ois = new ObjectInputStream(this.aLectura);
            IBDRegistroParking bd = (IBDRegistroParking) ois.readObject();
            ois.close();
            return bd;

        } catch (IOException | ClassNotFoundException e) {
            throw new ArchivoException(e.getMessage());
        }

    }

    private void guardar(IBDRegistroParking bd) throws ArchivoException {
        ObjectOutputStream oos = null;
        try {
            this.aEscritura = new FileOutputStream(this.archivo);
            oos = new ObjectOutputStream(this.aEscritura);
            oos.writeObject(bd);
            oos.close();
        } catch (IOException e) {
            throw new ArchivoException(e.getMessage());
        }

    }

    @Override
    public void registrarIngreso(RegistroParking registro) throws ArchivoException {
       
        IBDRegistroParking bd = this.leer();
        bd.registrarIngreso(registro);
        this.guardar(bd);
        
    }

    @Override
    public RegistroParking registrarSalida(String placa) throws ArchivoException {
        IBDRegistroParking bd = this.leer();
        return bd.registrarSalida(placa);
    }

    @Override
    public int size() throws ArchivoException {
        IBDRegistroParking bd = this.leer();
        return bd.size();
    }

    @Override
    public List<RegistroParking> listAll() throws ArchivoException {
            IBDRegistroParking bd = this.leer();
            return bd.listAll();
    }

    @Override
    public boolean contieneVehiculo(String placa) throws ArchivoException {
             IBDRegistroParking bd = this.leer();
            return bd.contieneVehiculo(placa);
    }

}
