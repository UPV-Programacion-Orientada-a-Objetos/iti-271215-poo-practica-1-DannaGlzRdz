package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
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
        while (!comando.equalsIgnoreCase("exit")) {
            comando = readLine().trim();

            if(comando.isEmpty()) continue;

            try {
                if(comando.toLowerCase().startsWith("use") && comando.toLowerCase().endsWith(";")){

                    String comandoCortado = comando.substring("use".length()).trim();
                    String rutaDeTrabajo = comandoCortado.replace(";", "");
                    dbManager.use(rutaDeTrabajo);
                } else if(comando.toLowerCase().startsWith("show tables") && comando.toLowerCase().endsWith(";")){

                    dbManager.mostrarTablas();

                } else if(comando.toLowerCase().startsWith("create tables") && comando.toLowerCase().endsWith(";")){

                    //dbManager.createTable(comando);

                } else  if(!comando.equalsIgnoreCase("exit")){
                    throw new IllegalArgumentException("Error de sintaxis");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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
