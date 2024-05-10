package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DataBaseManager {

    private Path rutaDeTrabajo;

    public void use(String path) {

        File file = new File(path);
        if (file.exists() && file.isDirectory()) {
            this.rutaDeTrabajo = Paths.get(path);
        } else {
            System.out.println("La ruta ingresada no es valida");
        }

    }

    public void mostrarTablas(){

        if (rutaDeTrabajo == null) {
            System.out.println("No se ha establecido ninguna ruta de trabajo");
            return;
        }

        File miDirectorio = rutaDeTrabajo.toFile();

        if (!miDirectorio.isDirectory()) {
            System.out.println("La ruta especificada no es un directorio valido");
            return;
        }
        String[] nombresDeArchivos = miDirectorio.list();


        if (nombresDeArchivos == null || nombresDeArchivos.length == 0) {
            System.out.println("No hay archivos en la ruta");
        }

        boolean csvEncontrado = false;

        for (String nombreDeArchivo : nombresDeArchivos) {

            if (nombreDeArchivo.endsWith(".csv")) {

                System.out.println(nombreDeArchivo);
                csvEncontrado = true;
            }


            if (!csvEncontrado) {
                System.out.println("No se ha encontrado ningun archivo csv");
            }
        }

    }


    }



