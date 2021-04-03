package com.cypherstudios.app;

import com.cypherstudios.gestionCuenta.CuentaBancaria;
import static com.cypherstudios.interfaces.IOperaciones.cuentasClientes;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppProg07 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        appPrincipal();
    }

    /**
     * Ejecuta el menú de operaciones.
     *
     * Mediante un switch, y dependiendo del valor de la variable int opcion,
     * ejecuta un case u otro, dependiendo de cual llama al método del ejercicio
     * correspondiente, incluidos en la clase MenuApp. Realiza esta acción
     * mientras que el valor de "opción" sea distinto de 7.
     *
     * En el caso 2 "Listar cuentas disponibles", mediante un foreach recorre el
     * ArrayList (instanciado en la interfaz IOperaciones), en el que se
     * almacenan las cuentas de los clientes. Mediante el método listarCuentas,
     * al que le envia el objeto aux, en el cual almacena cada objeto del
     * ArrayLis. Éste ArrayList esta instanciado en la interfaz IImprimir, que
     * está implementada en la clase CuentaBancaria imprime el contenido del
     * ArrayList
     */
    private static void appPrincipal() throws Exception {
        int opcion;

        do {
            opcion = menu();
            switch (opcion) {
                case 1:
                    //Abrir una nueva cuenta
                    System.out.println("\n/************************ ABRIR NUEVA CUENTA ****/\n");

                    appAperturaCuenta();

                    break;
                case 2:
                    //Ver un listado de las cuentas disponibles (CCC, titular y Saldo)
                    System.out.println("\n/*********************** CUENTAS DISPONIBLES ****/\n");

                    for (CuentaBancaria aux : cuentasClientes) {
                        aux.listarCuentas(aux);
                    }

                    break;
                case 3:
                    //Obtener los datos de una cuenta concreta

                    MenuApp.opcion03();

                    break;
                case 4:
                    //Realizar un ingreso en una cuenta

                    System.out.println("El saldo actual de la cuenta es: "
                            + MenuApp.opcion04()
                    );

                    break;
                case 5:
                    //Retirar efectivo de una cuenta
                    MenuApp.opcion05();

                    break;
                case 6:
                    //Consultar el saldo actual de una cuenta
                    MenuApp.opcion06();

                    break;

                case 7:

                    System.out.println("Hasta pronto!");
                    break;

            }
            if (opcion != 7) {
                // Pausar la salida por pantalla
                System.out.print(
                        "\n******************************** Operación finalizada. ***********"
                        + "\n******************************** PULSE INTRO PARA CONTINUAR ******\n"
                );
                try {
                    System.in.read();
                } catch (IOException ex) {
                }
            }
        } while (opcion != 7);
    }

    private static void appAperturaCuenta() throws Exception {
        int tipoCuenta;

        do {
            tipoCuenta = menuApertura();
            if (tipoCuenta == 1 || tipoCuenta == 2 || tipoCuenta == 3) {
                MenuApp.opcion01(tipoCuenta);
            } else if (tipoCuenta == 5) {
                System.out.println("Hasta pronto!");
                System.exit(0);
            } else {
                System.out.println("Volvemos al menú anterior");
            }
        } while (tipoCuenta == 1 || tipoCuenta == 2 || tipoCuenta == 3);

    }

    // Impresión de menús
    /**
     * Método para mostrar el menú principal del programa.
     *
     * El texto del menú esta almacenado en un array de Strings, y se imprime
     * mediante un foreach.
     *
     * Solicita al usuario la tarea que quiere realizar y
     *
     * @return opcion : devuelve el valor de "opcion" para ejecutar el switch en
     * el método appPrincipal()
     * @throws Exception : Recoge el mensage de error lanzado por el método
     * comprobarOpcion.
     * @throws InputMismatchException : Devuelve un error si el valor
     * introducido por teclado no es numérico.
     *
     */
    //private static String menuPal[] = new String[11];
    private static int menu() {
        int opcion = 0;
        String menuPal[] = {
            "\n****** MENÚ DE OPERACIONES **********************************************\n",
            "*                                                                       *\n",
            "* 1.-  Abrir una nueva cuenta                                           *\n",
            "* 2.-  Ver un listado de las cuentas disponibles (CCC, titular y Saldo) *\n",
            "* 3.-  Obtener los datos de una cuenta concreta                         *\n",
            "* 4.-  Realizar un ingreso en una cuenta                                *\n",
            "* 5.-  Retirar efectivo de una cuenta                                   *\n",
            "* 6.-  Consultar el saldo actual de una cuenta                          *\n",
            "* 7.-  Salir                                                            *\n",
            "*************************************************************************\n"
        };
        do {

            for (String linea : menuPal) {
                System.out.print(linea);
            }
            try {
                System.out.println("Escoge una opción del menú: ");

                opcion = teclado.nextInt();
                comprobarOpcion(opcion, menuPal);

            } catch (InputMismatchException e) {
                //Limpia el bufer de la clase Scanner, para que no entre en bucle
                teclado.nextLine();

                System.out.println("AVISO: Solo se admiten carácteres numéricos");
            } catch (Exception e) {
                //Captura el mensaje si la opcion no esta en el menú
                System.out.println(e.getMessage());
            }
        } while (opcion < 1 || opcion > (menuPal.length - 3));

        return opcion;
    }

    private static int menuApertura() {
        int tipoCuenta = -1;

        String menuApert[] = {
            "\n****** ESCOJE EL TIPO DE CUENTA *****************************************\n",
            "*                                                                       *\n",
            "* 1.- CUENTA DE AHORRO                                                  *\n",
            "* 2.- CUENTA CORRIENTE PERSONAL                                         *\n",
            "* 3.- CUENTA CORRIENTE EMPRESA                                          *\n",
            "* 4.- Volver al menú principal                                          *\n",
            "* 5.- Salir de la aplicación                                            *\n",
            "*************************************************************************\n"

        };
        do {
            for (String linea : menuApert) {
                System.out.print(linea);
            }
            try {
                System.out.println("Elige la opción que prefieras: ");

                tipoCuenta = teclado.nextInt();
                comprobarOpcion(tipoCuenta, menuApert);

            } catch (InputMismatchException e) {
                //Limpia el bufer de la clase Scanner, para que no entre en bucle
                teclado.nextLine();

                System.out.println("AVISO: Solo se admiten carácteres numéricos");
            } catch (Exception e) {
                //Captura el mensaje si la opcion no esta en el menú
                System.out.println(e.getMessage());
            }
        } while (tipoCuenta < 1 || tipoCuenta > (menuApert.length - 3));

        return tipoCuenta;

    }

    /**
     * Método que comprueba si el valor introducido esta en el rango de las
     * opciones del menú principal ( de 1 a 7 )
     *
     * @param opcion : recibe el valor introducido por teclado
     * @throws Exception : Devuelve un error si el valor introducido no existe
     * en el menú de operaciones
     */
    private static void comprobarOpcion(int opcion, String[] menu) throws Exception {

        if (opcion < 1 || opcion > menu.length - 3) {
            throw new Exception("El valor introducido no es válido.\n"
                    + "Por favor selecciona una de las opciones indicadas."
                    + "Valores entre 1 y " + (menu.length - 3)
            );
        }
    }
}
