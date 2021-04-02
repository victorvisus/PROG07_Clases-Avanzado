package com.cypherstudios.app;

import static com.cypherstudios.app.AppProg07.teclado;
import com.cypherstudios.gestionCuenta.*;
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
    public static void opcion01(int tipoCuenta) throws Exception {
        boolean continua = false;
        Persona titular;
        CodigoCuenta codCuentaCliente;
        double saldo = 0;

        System.out.println("\n/*************** APERTURA DE CUENTA BANCARIA ****/\n");

        if (tipoCuenta == 1) {
            System.out.println("\n/**** CUENTA DE AHORRO ****/");

            double tipoInteres = 0;
            titular = solicitaTitular();
            codCuentaCliente = solicitaCodigo();

            while (continua == false) {
                try {
                    continua = true;
                    System.out.println("Indicame el saldo de apertura");
                    saldo = teclado.nextDouble();
                    comprobarImporte(saldo);

                    System.out.println("Indica el tipo de interes:");
                    tipoInteres = teclado.nextDouble();
                } catch (InputMismatchException e) {
                    //Limpia el bufer de la clase Scanner, para que no entre en bucle
                    teclado.nextLine();

                    System.out.println("AVISO: Solo se admiten carácteres numéricos");
                    continua = false;
                }
            }

            CuentaBancaria ca = new CuentaAhorro(titular, codCuentaCliente, saldo, tipoInteres);
        }

        if (tipoCuenta == 2) {
            System.out.println("\n/**** CUENTA CORRIENTE PERSONAL ****/");

            double comision = 0;
            titular = solicitaTitular();
            codCuentaCliente = solicitaCodigo();

            while (continua == false) {
                try {
                    continua = true;
                    System.out.println("Indicame el saldo de apertura");
                    saldo = teclado.nextDouble();
                    comprobarImporte(saldo);

                    System.out.println("Indica la comisión:");
                    comision = teclado.nextDouble();
                } catch (InputMismatchException e) {
                    //Limpia el bufer de la clase Scanner, para que no entre en bucle
                    teclado.nextLine();

                    System.out.println("AVISO: Solo se admiten carácteres numéricos");
                    continua = false;
                }
            }

            CuentaBancaria ccp = new CtaPersonal(titular, codCuentaCliente, saldo, comision);
        }

        if (tipoCuenta == 3) {
            System.out.println("CUENTA CORRIENTE EMPRESA");

            double maxDescubierto = 0;
            double tipoIntDesc = 0;
            double comisionDesc = 0;
            titular = solicitaTitular();
            codCuentaCliente = solicitaCodigo();

            while (continua == false) {
                try {
                    continua = true;
                    System.out.println("Indicame el saldo de apertura");
                    saldo = teclado.nextDouble();
                    comprobarImporte(saldo);

                    System.out.println("Indica el importe máximo permitido de descubierto:");
                    maxDescubierto = teclado.nextDouble();

                    System.out.println("Indica el tipo de interes por descubierto:");
                    tipoIntDesc = teclado.nextDouble();

                    System.out.println("Indica la comisión por descubierto:");
                    comisionDesc = teclado.nextDouble();
                } catch (InputMismatchException e) {
                    //Limpia el bufer de la clase Scanner, para que no entre en bucle
                    teclado.nextLine();

                    System.out.println("AVISO: Solo se admiten carácteres numéricos");
                    continua = false;
                }
            }

            CuentaBancaria ccp = new CtaEmpresa(titular, codCuentaCliente, saldo,
                    maxDescubierto, tipoIntDesc, comisionDesc);
        }

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

    private static Persona solicitaTitular() {
        teclado.nextLine();

        String nombre;
        String apellidos;
        String fecha_nac;

        System.out.println("Introduce el nombre del titular:");
        nombre = teclado.nextLine();

        System.out.println("Introduce los apellidos del titular:");
        apellidos = teclado.nextLine();

        System.out.println("Introduce la fecha de nacimiento:");
        fecha_nac = teclado.nextLine();

        Persona titular = new Persona(nombre, apellidos, fecha_nac);

        return titular;
    }

    private static CodigoCuenta solicitaCodigo() {
        String codCompleto;

        do {
            System.out.println("Introduce el numero de cuenta (20 digitos):");
            codCompleto = teclado.nextLine();
        } while (!CodigoCuenta.validarCCC(codCompleto));

        CodigoCuenta codCuentaCliente = new CodigoCuenta(codCompleto);

        return codCuentaCliente;
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
