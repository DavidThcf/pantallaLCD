/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdtester;

/**
 *
 * @author David Estrada
 */
public class Proceso {

    /**
     *
     * Metodo encargado de procesar la entrada que contiene el size del segmento
     * de los digitos y los digitos a imprimir
     *
     * @param comando Entrada que contiene el size del segmento de los digito y
     * el numero a imprimir
     * @param espacioDig Espacio Entre digitos
     */
    static String procesar(String comando) {
        try {
            String[] parametros;

            int tam = 0;
            String error = "";

            //Verifica si la cadena contiene caracter ,
            if (!comando.contains(",")) {
                error = error + "Cadena " + comando + " no contiene caracter ,";
            }

            //Se hace el split de la cadena
            parametros = comando.split(",");

            //Valida la cantidad de parametros
            if (parametros.length > 2) {
                error = error + "\nCadena " + comando
                        + " contiene mas caracter ,";
            }

            //Valida la cantidad de parametros
            if (parametros.length < 2) {
                error = error + "\nCadena " + comando
                        + " no contiene los parametros requeridos";
            }

            //Valida que el parametro size sea un numerico
            if (isNumeric(parametros[0])) {
                tam = Integer.parseInt(parametros[0]);

                // se valida que el size este entre 1 y 10
                if (tam < 1 || tam > 10) {
                    error = error + "\nEl parametro size [" + tam
                            + "] debe estar entre 1 y 10";
                }
            } else {
                error = error + "\nParametro Size [" + parametros[0]
                        + "] no es un numero";
            }

            //Valida si el Valor es numerico
            if (!isNumeric(parametros[1])) {
                error = error + "\nParametro Value [" + parametros[1]
                        + "] no es un numero";
            }
            ///DEvueleve el Mensaje de Error
            if (!error.equalsIgnoreCase("")) {
                return error;

            } else {
                ImpresorLCD.imprimirNumero(tam, parametros[1]);
            }

            return "";

        } catch (Exception ex) {
            return "Error: " + ex.getMessage();
        }

    }

    /**
     *
     * Metodo encargado de validar si una cadena es numerica
     *
     * @param value Valor a validar
     */
    static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

}
