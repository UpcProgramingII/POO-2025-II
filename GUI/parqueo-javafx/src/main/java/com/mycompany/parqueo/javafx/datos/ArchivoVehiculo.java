/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.parqueo.javafx.datos;

import com.mycompany.parqueo.javafx.dominio.Auto;
import com.mycompany.parqueo.javafx.dominio.Bicicleta;
import com.mycompany.parqueo.javafx.dominio.Moto;
import com.mycompany.parqueo.javafx.dominio.Vehiculo;
import com.mycompany.parqueo.javafx.excepciones.ArchivoException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Jairo F
 */
// gestiona un archivo texto para los datos d elos vehiculos
public class ArchivoVehiculo implements IBDVehiculo {

    private File archivo; // objeto archivo a gestionar
    private FileWriter aEscritura; // 
    private Scanner aLectura;

    public ArchivoVehiculo() throws ArchivoException {
        this.archivo = new File("Vehiculos.dat");
        try {
            if (!this.archivo.exists()) {
                this.archivo.createNewFile();
            }
        } catch (IOException e) {
            throw new ArchivoException("Error al crear archivo de vehiculos");
        }
    }

    @Override
    public void adicionarVehiculo(Vehiculo v) throws ArchivoException {
        PrintWriter pw = null;
        try {
            this.aEscritura = new FileWriter(this.archivo, true); // abre archivo en modo escritura
            pw = new PrintWriter(this.aEscritura);
            pw.println(v.getInfo());

        } catch (IOException | SecurityException e) {
            throw new ArchivoException("Error al crear archivo escritura");
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    @Override
    public List<Vehiculo> listarTodos() throws ArchivoException {

        try {
            this.aLectura = new Scanner(this.archivo);
            List<Vehiculo> lista = new ArrayList();
            while (this.aLectura.hasNext()) {
                String datos[] = this.aLectura.nextLine().split(";");
                Vehiculo v;
                if (datos[0].equals("Moto")) {
                    v = new Moto(datos[1], datos[2], Integer.parseInt(datos[3]));

                } else if (datos[0].equals("Auto")) {
                    v = new Auto(datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
                } else {
                    v = new Bicicleta(datos[1], datos[2], datos[3].equals("true") ? true : false);
                }
                lista.add(v);
            }
            return lista;
        } catch (SecurityException | IOException e) {
            throw new ArchivoException("Error al leer archivo de vehiculo");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }

    }

    @Override
    public Vehiculo buscar(String placa) throws ArchivoException {

        try {
            this.aLectura = new Scanner(this.archivo);
            Vehiculo v;
            while (this.aLectura.hasNext()) {
                String datos[] = this.aLectura.nextLine().split(";");
                if (placa.equals(datos[1])) {
                    if (datos[0].equals("Moto")) {
                        v = new Moto(datos[1], datos[2], Integer.parseInt(datos[3]));

                    } else if (datos[0].equals("Auto")) {
                        v = new Auto(datos[1], datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]));
                    } else {
                        v = new Bicicleta(datos[1], datos[2], datos[3].equals("true") ? true : false);
                    }
                    return v;
                }

            }
            return null;
        } catch (SecurityException | IOException e) {
            throw new ArchivoException("Error al leer archivo de vehiculo");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }

    }

    @Override
    public void eliminar(String placa) throws ArchivoException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean exist(String placa) throws ArchivoException {

        try {
            this.aLectura = new Scanner(this.archivo);
            while (this.aLectura.hasNext()) {
                String datos[] = this.aLectura.nextLine().split(";");
                if (placa.equals(datos[1])) {
                    return true;
                }
            }
            return false;
        } catch (SecurityException | IOException e) {
            throw new ArchivoException("Error al leer archivo de vehiculo");
        } finally {
            if (this.aLectura != null) {
                this.aLectura.close();
            }
        }
    }

}
