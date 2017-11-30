/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdtester;

/**
 *
 * @author David E
 */
public class ImpresorLCD {

    //Varibales que contienen los segmentos(7) que componen un numero
    static String number0 = "123567";
    static String number1 = "36";
    static String number2 = "13457";
    static String number3 = "13467";
    static String number4 = "2346";
    static String number5 = "12467";
    static String number6 = "124567";
    static String number7 = "136";
    static String number8 = "1234567";
    static String number9 = "123467";

    /**
     *
     * Metodo encargado de ejeccutar lo metodos necesarios para imprimir un
     * numero
     *
     * @param size Tamaño Segmento Digitos
     * @param value Numero a Imprimir
     */
    static void imprimirNumero(int size, String value) {
        try {
            //Obtenemos el arreglo de numeros
            String[] arrayValue = value.split("");
            //Obtenemos la cantidad de numeros a Imprimir
            int valueLength = value.length();
            imprimirSegmentosHorizontales(arrayValue, valueLength, size, 1);
        } catch (Exception ex) {
            System.out.println("Error imprimirNumero: " + ex.getMessage());
        }

    }

    /**
     *
     * Metodo encargado de imprimir los segmentos horizontales(Fislas) que
     * componen un numero
     *
     * @param arrayValue arreglo de numeros a imprimir
     * @param valueLength cantidad de numeros a imprimir
     * @param size Variable que tiene que contitne el tamaño de impresion
     * @param segmento variable que especifica el segmento a graficar
     */
    static void imprimirSegmentosHorizontales(String[] arrayValue, int valueLength, int size, int segmento) {
        try {
            // Ciclo Recorre la cantidad de veces  que se imprime los segmentos 1,4 y 7
            for (int i = 0; i < valueLength; i++) {
                //Verificamos si el numero esta compuesto por  el segmento a graficar
                boolean isValid = validarSegmento(arrayValue[i], segmento);
                System.out.print(" ");
                //Ciclo que permite graficar el tamaño de impresion en los segmentos horizontales
                for (int j = 0; j < size; j++) {
                    //Si el numero esta compuesto por el numero a graficar se imprime ls linea Horizontal
                    //de lo conmtarrio se iomporime un espoacio vacio
                    if (isValid) {
                        System.out.print("-");

                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.print("  ");
            }
            //Imprime salto de linea para imprmir segementos verticales
            System.out.println();

            //Se controla la impresion de los segmentos verticales(filas) con el fin de evitar ciclo infinito
            if (segmento == 1 || segmento == 4) {
                segmento = segmento + 1;
                imprimirSegmentosVerticales(arrayValue, valueLength, size, segmento);
            }
        } catch (Exception ex) {
            System.out.println("Error imprimirSegmentosHorizontales: " + ex.getMessage());
        }
    }

    /**
     *
     * Metodo encargado de imprimir los segmentos verticales(columnas) que
     * componen un numero
     *
     * @param arrayValue arreglo de numeros a imprimir
     * @param valueLength cantidad de numeros a imprimir
     * @param size Variable que tiene que contitne el tamaño de impresion
     * @param segmento variable que especifica el segmento a graficar
     */
    static void imprimirSegmentosVerticales(String[] arrayValue, int valueLenght, int size, int segmento) {
        try {
            //Ciclo que permite graficar el tamaño de impresion en los segmentos Veerticales
            for (int i = 0; i < size; i++) {

                // Ciclo Recorre la cantidad de veces que se imprimen los segmentos 2,3,5 y 6
                for (int j = 0; j < valueLenght; j++) {

                    //Condicion nos permite cambiar los segmentos 3 y 6 a 2 y 5 cuando  se avanza de numero
                    //a imprimir
                    if (segmento == 3 || segmento == 6) {
                        segmento = segmento - 1;
                    }
                    //Verificamos si el numero esta compuesto por  el segmento(2,5) a graficar
                    boolean isValid = validarSegmento(arrayValue[j], segmento);
                    imprimirLineaVertical(isValid, "|", "left");

                    //imprime espacios entre columnas segun el tamaño de impresion
                    for (int y = 0; y < size; y++) {
                        System.out.print(" ");
                    }

                    //Condicion nos permite cambiar los segmentos 2 y 5 a 3 y 6 cuando  se avanza de numero
                    //a imprimir
                    if (segmento == 2 || segmento == 5) {
                        segmento = segmento + 1;
                    }
                    //Verificamos si el numero esta compuesto por  el segmento(5,6) a graficar
                    isValid = validarSegmento(arrayValue[j], segmento);
                    imprimirLineaVertical(isValid, "| ", "right");
                }
                //imprime salto de linea
                System.out.println(" ");
            }

            segmento = segmento + 1;
            imprimirSegmentosHorizontales(arrayValue, valueLenght, size, segmento);
        } catch (Exception ex) {
            System.out.println("Error imprimirSegmentosVerticales: " + ex.getMessage());
        }
    }

    /**
     *
     * Metodo encargado de imprimir los linea verticales(columnas) que
     *
     * @param isValid variable que iondica si debe dibujar la linea
     * @param lineaVertical caracter a imprimir
     * @param posicion indica la posicion en la que se dibujara la lina
     */
    static void imprimirLineaVertical(boolean isValid, String lineaVertical, String posicion) {
        try {
            //Si el numero esta compuesto por el numero a graficar se imprime ls linea Vertical
            //de lo conmtario se iomporime un espacio vacio
            if (isValid) {
                System.out.print(lineaVertical);
            } else {
                //sev verifica si la linea se grafica en la columna izqwuierda de lo contrario se agrega espacio par nuevo numero
                if (posicion.equals("left")) {
                    System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
            }
        } catch (Exception ex) {
            System.out.println("Error imprimirLineaVertical: " + ex.getMessage());
        }
    }

    /**
     *
     * Metodo encargado de Verificar si el numero esta compuesto por el segmento
     * a graficar
     *
     * @param number numero a graficar
     * @param segmento segemtno que se va a graficar
     */
    static boolean validarSegmento(String number, int segmento) {

        switch (number) {
            case "0":
                return number0.contains(segmento + "");
            case "1":
                return number1.contains(segmento + "");
            case "2":
                return number2.contains(segmento + "");
            case "3":
                return number3.contains(segmento + "");
            case "4":
                return number4.contains(segmento + "");
            case "5":
                return number5.contains(segmento + "");
            case "6":
                return number6.contains(segmento + "");
            case "7":
                return number7.contains(segmento + "");
            case "8":
                return number8.contains(segmento + "");
            case "9":
                return number9.contains(segmento + "");

        }
        return true;
    }
}
