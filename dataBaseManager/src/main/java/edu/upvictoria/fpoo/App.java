package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.IllformedLocaleException;

/**
 * Hello world!
 *
 * USE /home/danna/Documents/prueba1;
 */
public class App
{
    public static void main( String[] args )
    {

        DataBaseManager dbManager = new DataBaseManager();


        System.out.println("Sentencia:");

        String comando = "";
        while (!comando.endsWith("exit")) {
            comando = readLine().trim();

            if(comando.isEmpty()) continue;

            if(comando.toLowerCase().startsWith("use")){

                String comandoCortado = comando.substring("use".length()).trim();
                String rutaDeTrabajo = comandoCortado.replace(";","");
                System.out.println(rutaDeTrabajo);
                dbManager.use(rutaDeTrabajo);

            }  else if (comando.toLowerCase().startsWith("show tables")) {

                dbManager.mostrarTablas();

            } else if(comando.toLowerCase().startsWith("create table")){
                //dbManager.createTable(comando);
            }
        }
    }

    public static String readLine() {
        String linea = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            linea = br.readLine();
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al leer el entrada:\n" + e.getMessage());
        } catch (NullPointerException e) {
            System.err.println("El BufferedReader esta es nulo:\n" + e.getMessage());
        } catch (SecurityException e) {
            System.err.println("Hubo una excepcion de seguridad:\n" + e.getMessage());
        }  catch (IllformedLocaleException e) {
            System.err.println("Hubo un argumento ilegal:\n" + e.getMessage());
        }

        return linea;
    }
}
