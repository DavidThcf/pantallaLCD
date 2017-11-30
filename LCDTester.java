/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdtester;

import java.util.Scanner;

/**
 *
 * @author Orlando David Estrada
 */
public class LCDTester {

    /**
     * @param args the command line arguments
     */
    static final String CADENA_FINAL = "0,0";

    public static void main(String[] args) {
        //variabl;e alamcena la el numero a imprimir
        String comando = "";
        //variable alamacena los mensajes de error
        String mensaje = "";

        try {
            //Ciclo mantiene activa la aplicaion
            do {
                System.out.print("Numero a Imprimir (Size , Value): ");
                Scanner lector = new Scanner(System.in);
                comando = lector.next();
                if (!comando.equalsIgnoreCase(CADENA_FINAL)) {
                    mensaje = Proceso.procesar(comando);
                    if (!mensaje.equalsIgnoreCase("")) {
                        System.out.println("Error: " + mensaje);
                        System.out.println();
                    }
                }
            } while (!comando.equalsIgnoreCase(CADENA_FINAL));
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

}
