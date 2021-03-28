package com.cypherstudios.app;

import static com.cypherstudios.app.AppProg07.teclado;
import com.cypherstudios.gestionCuenta.CuentaBancaria;
import java.util.InputMismatchException;

/**
 *
 * @author Victor
 */
public class MenuApp {

    /**
     * Declaro la variable estática indice de tipo int. Su valor será el que
     * devuelva el método seleccionarCuenta() cuando sea llamado por las
     * distintas opciones del menú
     */
    private static int indice;
    private static boolean error = false;

    //Abrir una nueva cuenta
    public static void opcion01() throws Exception {


    }

    //Obtener los datos de una cuenta concreta
    public static void opcion03() throws Exception {
        System.out.println("\n/*************** OBTENER DATOS DE UNA CUENTA ****/\n");

        seleccionarCuenta();
        System.out.println(
                CuentaBancaria.cuentasClientes.get(indice).detallesCuenta(indice)
        );
    }

    //Realizar un ingreso en una cuenta
    public static double opcion04() throws Exception {
        System.out.println("\n/************************* INGRESO EN CUENTA ****/\n");
        seleccionarCuenta();

        double importe = introducirImporte();
        double saldoAnt = CuentaBancaria.cuentasClientes.get(indice).getSaldo();

        double saldoAct = saldoAnt + importe;

        CuentaBancaria.cuentasClientes.get(indice).setSaldo(saldoAct);

        return saldoAct;
    }

    //Retirar efectivo de una cuenta
    public static double opcion05() throws Exception {

        System.out.println("\n/********************** RETIRADA DE EFECTIVO ****/\n");

        seleccionarCuenta();
        double importe;
        double saldo;
        double saldoAct = 0;
        do {
            try {
                error = false;
                importe = introducirImporte();
                saldo = CuentaBancaria.cuentasClientes.get(indice).getSaldo();

                comprobarSaldo(saldo, importe);

                saldoAct = saldo - importe;

                CuentaBancaria.cuentasClientes.get(indice).setSaldo(saldoAct);
            } catch (Exception e) {
                //Captura el mensaje si no hay o no hay suficiente saldo.
                System.out.println(e.getMessage());
                error = true;
            }
        } while (error);

        return saldoAct;
    }

    //Consultar el saldo actual de una cuenta
    public static void opcion06() throws Exception {
        seleccionarCuenta();
        CuentaBancaria.cuentasClientes.get(indice).consultarSaldo(indice);

    }

    // Métodos para solicitar datos al usuario
    private static int seleccionarCuenta() throws Exception {

        try {
            comprobarExisteCuenta();

            CuentaBancaria.previewCuentas();
            System.out.println("Escoje la cuenta con la que operar"
                    + "\nDime el ID de la cuenta:");
            int idCuenta = teclado.nextInt();

            indice = CuentaBancaria.buscarCuenta(idCuenta);
            comprobarIndiceCuenta(indice);
        } catch (InputMismatchException e) {
            //Limpia el bufer de la clase Scanner, para que no entre en bucle
            teclado.nextLine();

            System.out.println("AVISO: Solo se admiten carácteres numéricos");
        } catch (Exception e) {
            //Captura el mensaje si el ID de la cuenta no existe
            System.out.println(e.getMessage());
        }

        return indice;
    }

    private static double introducirImporte() {
        double importe = 0;
        try {
            System.out.println("Introduce un importe");
            importe = teclado.nextDouble();
            comprobarImporte(importe);

        } catch (InputMismatchException e) {
            System.out.println("Sólo se admiten caaracteres númericos");
        } catch (Exception e) {
            //Captura el mensaje si el importe es negativo
            System.out.println(e.getMessage());
        }

        return importe;
    }

    // Métodos para realizar comprobaciones //
    /**
     * Comprueba que la cuenta seleccionada existe
     *
     * @param indice :
     * @throws Exception :
     */
    private static void comprobarIndiceCuenta(int indice) throws Exception {
        if (indice == -1) {
            throw new Exception("El ID de Cuenta no es válido.\n");
        }
    }

    private static void comprobarExisteCuenta() throws Exception {
        if (CuentaBancaria.cuentasClientes.isEmpty()) {
            throw new Exception("No se ha encontrado ninguna cuenta en el sistema.\n");
        }
    }

    private static void comprobarImporte(double importe) {
        if (importe < 0) {
            System.out.println("No es posible operar con importe negativos");
        }
    }

    private static void comprobarSaldo(double saldo, double importe) throws Exception {
        if (saldo == 0 || importe > saldo) {
            System.out.println("Operación no disponible. "
                    + "\nNo tiene suficiente saldo disponible."
                    + "\nSu saldo actual es: " + saldo);
        }
    }

    /**
     * Método que comprueba si el valor introducido esta en el rango de las
     * opciones del menú principal ( de 1 a 7 )
     *
     * @param opcion : recibe el valor introducido por teclado
     * @throws Exception : Devuelve un error si el valor introducido no existe
     * en el menú de operaciones
     */
    public static void comprobarOpcion(int opcion, String[] menu) throws Exception {

        if (opcion < 1 || opcion > menu.length - 3) {
            throw new Exception("El valor introducido no es válido.\n"
                    + "Por favor selecciona una de las opciones indicadas."
                    + "Valores entre 1 y " + (menu.length - 3)
            );
        }
    }
}
