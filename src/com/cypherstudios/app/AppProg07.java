package com.cypherstudios.app;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppProg07 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        appPrincipal();
    }

    /**
     * Ejecuta el menú de operaciones.
     *
     * Mediante un switch, y dependiendo del valor de la variable int opcion,
     * ejecuta un case u otro, dependiendo de cual llama al método del ejercicio
     * correspondiente.. Realiza esta acción mientras que el valor de "opción"
     * sea distinto de .....
     */
    private static void appPrincipal() {
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    //Abrir una nueva cuenta

                    break;
                case 2:
                    //Ver un listado de las cuentas disponibles (CCC, titular y Saldo)

                    break;
                case 3:
                    //Obtener los datos de una cuenta concreta

                    break;
                case 4:
                    //Realizar un ingreso en una cuenta

                    break;
                case 5:
                    //Retirar efectivo de una cuenta

                    break;
                case 6:
                    //Consultar el saldo actual de una cuenta

                    break;
                case 7:

                    System.out.println("Hasta pronto!");
                    break;

            }
            if (opcion != 7) {
                // Pausar la salida por pantalla
                System.out.print(
                        "\n******************************** Operación finalizada."
                        + "\n******************************** PULSE INTRO PARA CONTINUAR ******\n"
                );
                try {
                    System.in.read();
                } catch (IOException ex) {
                }
            }
        } while (opcion != 7);
    }

    /**
     * Método para mostrar el menú que se solicita en la tarea. Primero imprime
     * las opciones del menú, cada una con la numeración correspondiente al
     * ejercicio, y solicita al usuario que introduzca el nº de ejercicio que
     * quiere visualizar. Realiza esta acción hasta que el usuario indique que
     * quiere salir.
     *
     * @return opcion : devuelve el valor de "opcion" para ejecutar el switch en
     * el método appPrincipal()
     * @throws Exception : Recoge el mensage de error lanzado por el método
     * comprobarOpcion.
     * @throws InputMismatchException : Devuelve un error si el valor
     * introducido por teclado no es numérico.
     *
     *
     */
    private static int menu() {
        int opcion = 0;
        do {
            System.out.println(
                    "\n****** MENÚ DE OPERACIONES ***************************************\n"
                    + "*                                                                *\n"
                    + "* 1.-  Abrir una nueva cuenta                                    *\n"
                    + "* 2.-  Ver un listado de las cuentas disponibles                 *\n"
                    + "*      (CCC, titular y Saldo)                                    *\n"
                    + "* 3.-  Obtener los datos de una cuenta concreta                  *\n"
                    + "* 4.-  Realizar un ingreso en una cuenta                         *\n"
                    + "* 5.-  Retirar efectivo de una cuenta                            *\n"
                    + "* 6.-  Consultar el saldo actual de una cuenta                   *\n"
                    + "* 7.-  Salir                                                     *\n"
                    + "******************************************************************\n"
            );

            try {
                System.out.println("Escoge una opción del menú: ");

                opcion = teclado.nextInt();
                comprobarOpcion(opcion);

            } catch (InputMismatchException e) {
                //Limpia el bufer de la clase Scanner, para que no entre en bucle
                teclado.nextLine();

                System.out.println("AVISO: Solo se admiten carácteres numéricos");
            } catch (Exception e) {
                //Captura el mensaje si la opcion no esta en el menú
                System.out.println(e.getMessage());
            }
        } while (opcion < 1 || opcion > 7);

        return opcion;
    }

    /**
     * Método que comprueba si el valor introducido esta en el rango de las
     * opciones del menú principal ( de 1 a 7 )
     *
     * @param opcion : recibe el valor introducido por teclado
     * @throws Exception : Devuelve un error si el valor introducido no existe
     * en el menú de operaciones
     */
    private static void comprobarOpcion(int opcion) throws Exception {
        if (opcion < 1 || opcion > 7) {
            throw new Exception("El valor introducido no es válido.\n"
                    + "Por favor selecciona una de las opciones indicadas."
            );
        }
    }

}
