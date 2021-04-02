package com.cypherstudios.app;

import com.cypherstudios.gestionCuenta.CuentaBancaria;
import static com.cypherstudios.interfaces.IOperaciones.cuentasClientes;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AppProg07 {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
//
//        Persona t4 = new Persona("fer4", "uri4", "01/01/1956");
//        CodigoCuenta ccc4 = new CodigoCuenta("01234567890123456789");
//        CuentaBancaria c4 = new CuentaAhorro(t4, ccc4, 4000, 12.00);
//
//        Persona t5 = new Persona("fer5", "uri5", "23/02/1976");
//        CodigoCuenta ccc5 = new CodigoCuenta("01234567890123456789");
//        CuentaBancaria c5 = new CuentaAhorro(t5, ccc5, 5000, 12.00);
//
//        Persona t6 = new Persona("fer5", "uri5", "23/05/1995");
//        CodigoCuenta ccc6 = new CodigoCuenta("01234567890123456789");
//        CuentaBancaria c6 = new CtaPersonal(t6, ccc6, 2000, 12);
//
//        Persona t7 = new Persona("fer7", "uri7", "30/07/1987");
//        CodigoCuenta ccc7 = new CodigoCuenta("01234567890123456789");
//        CuentaBancaria c7 = new CtaEmpresa(t7, ccc7, 20000, 1000, 10, 30);

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
                MenuApp.comprobarOpcion(opcion, menuPal);

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
                MenuApp.comprobarOpcion(tipoCuenta, menuApert);

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
}
