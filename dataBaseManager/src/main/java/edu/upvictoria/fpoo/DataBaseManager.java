package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.ArrayArrayList;

public class DataBaseManager {

    private Path rutaDeTrabajo;

    public void use(String path) {

        this.rutaDeTrabajo = Paths.get(path);
    }

    public String getWorkingPath() {

        return rutaDeTrabajo.toString();
    }

    public void mostrarTablas(){

        if (rutaDeTrabajo == null) {
            System.out.println("No se ha establecido ninguna ruta de trabajo");
            return;
        } else {
            System.out.println("Se establecido una ruta de trabajo");
        }

        File miDirectorio = rutaDeTrabajo.toFile();

        if (!miDirectorio.isDirectory()) {
            System.out.println("La ruta especificada no es un directorio valido");
            return;
        }
        String[] containingFileNames = miDirectorio.list();

        if (containingFileNames == null) {
            System.out.println("No hay archivos en la ruta");
        }

        for (String fileName : containingFileNames) {

            if (fileName.endsWith(".csv")) {

                System.out.println(fileName);
            } else {
                System.out.println("No se ha encontrado ningun archivo csv");
            }
        }

        /*for (String filename : containingFileNames) {
            if (filename.endsWith(".csv")) {

                StringBuilder sb = new StringBuilder();
                Path filePath = rutaDeTrabajo.resolve(filename);

                try{
                    BufferedReader br = Files.newBufferedReader(filePath);

                    String line;
                    while ((line = br.readLine()) != null) {
                        sb.append(line).append("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(sb);
            }
        }*/
    }
}
