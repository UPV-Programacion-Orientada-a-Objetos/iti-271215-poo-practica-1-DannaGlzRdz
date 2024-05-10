package edu.upvictoria.fpoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 * USE /home/danna/Documents/prueba1;
 */
public class App
{
    public static void main( String[] args )
    {
        String[] palabrasReservadas = {
                "from", "where", "group by", "having", "select", "order by", "limit"
        };

        DataBaseManager dbManager = new DataBaseManager();

        String[] palReservadasCreateTable = {

        };

        System.out.println("Sentencia:");

        String comando = "";
        while (!comando.endsWith("exit")) {
            comando = readLine().trim();

            if(comando.isEmpty()) continue;

            if(comando.toLowerCase().startsWith("use")){

                String comandoC = comando.substring("use".length()).trim();
                String rutaDeTrabajo = comandoC.replace(";","");
                System.out.println(rutaDeTrabajo);
                dbManager.use(rutaDeTrabajo);

            }  else if (comando.toLowerCase().startsWith("show tables")) {

                dbManager.mostrarTablas();

            } else if(comando.toLowerCase().startsWith("create table")){

            }
        }
    }

    public static String readLine() {
        String line = "";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            line = br.readLine();
        } catch (IOException e) {
            System.err.println("Ha ocurrido un error al leer el entrada");
        }

        return line;
    }
}
