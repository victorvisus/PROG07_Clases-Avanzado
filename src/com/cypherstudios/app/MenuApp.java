package com.cypherstudios.app;

import static com.cypherstudios.app.AppProg07.teclado;
import com.cypherstudios.gestionCuenta.*;
import static com.cypherstudios.interfaces.IOperaciones.cuentasClientes;
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
    private static int indice = -1;
    private static boolean error = false;
    private static String avisoVolver = "Volvemos al menú principal";

    /**
     *
     * @param tipoCuenta : correspondiente al número de opcion elejido en el
     * método menuApertura() de la clase AppProg07
     *
     * Usa los métodos solicitaTitular() y solicitaCodigo() que solicitan los
     * datos, construyen y devuelven los objetos "titular" de tipo Persona y
     * "codCuentaCliente" de tipo CodigoCuenta.
     *
     * Dependiendo del tipo de cuenta elejido solicitará los atributos
     * característicos del tipo correspondiente.
     *
     * @throws Exception
     */
    public static void opcion01(int tipoCuenta) throws Exception {
        //Abrir una nueva cuenta
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

    /**
     * Listar cuentas disponibles, mediante un foreach recorre el ArrayList
     * (instanciado en la interfaz IOperaciones), en el que se almacenan las
     * cuentas de los clientes. Mediante el método listarCuentas, al que le
     * envia el objeto aux, en el cual almacena cada objeto del ArrayLis. Éste
     * ArrayList esta instanciado en la interfaz IImprimir, que está
     * implementada en la clase CuentaBancaria imprime el contenido del
     * ArrayList
     */
    public static void opcion02() {
        /**
         * Llama al método que se encarga de imprimir el listado de cuentas
         * almacenadas, dependiendo del tipo de cuenta que este almacenada usara
         * el método que corresponda
         */
        try {
            comprobarExisteCuenta();
            for (CuentaBancaria aux : cuentasClientes) {
                aux.listarCuentas(aux);
            }
        } catch (Exception e) {
            System.out.println(avisoVolver);
        }
    }

    /**
     * Manda a seleccionar la cuenta por medio del método indicado, que devuelve
     * el valor de la variable de clase "indice", el cual se usa para indicar de
     * que cuenta se quieren extraer los datos.
     *
     * @throws Exception
     */
    //Obtener los datos de una cuenta concreta
    public static void opcion03() {
        System.out.println("\n/*************** OBTENER DATOS DE UNA CUENTA ****/\n");

        try {
            seleccionarCuenta();

            System.out.println(
                    CuentaBancaria.cuentasClientes.get(indice).detallesCuenta(indice)
            );
        } catch (Exception e) {
            System.out.println(avisoVolver);
        }
    }

    //Realizar un ingreso en una cuenta
    public static void opcion04() {
        System.out.println("\n/************************* INGRESO EN CUENTA ****/\n");

        seleccionarCuenta();

        if (indice != -1) {
            double importe = introducirImporte();

            System.out.println("El saldo actual de la cuenta es: "
                    + CuentaBancaria.cuentasClientes.get(indice).ingresarEfectivo(importe)
            );
        }

    }

    //Retirar efectivo de una cuenta
    public static void opcion05() {
        double importe = 0;
        System.out.println("\n/********************** RETIRADA DE EFECTIVO ****/\n");

        seleccionarCuenta();
        if (indice != -1) {
            importe = introducirImporte();

            System.out.println("El saldo actual de la cuenta es: "
                    + CuentaBancaria.cuentasClientes.get(indice).retirarEfectivo(importe));
        }
        //return CuentaBancaria.cuentasClientes.get(indice).retirarEfectivo(importe);
    }

    //Consultar el saldo actual de una cuenta
    public static void opcion06() {
        try {
            seleccionarCuenta();
            CuentaBancaria.cuentasClientes.get(indice).consultarSaldo(indice);
        } catch (Exception e) {
            System.out.println(avisoVolver);
        }

    }

    /**
     * Método para imprimir los datos de una cuenta concreta.
     *
     * Primero comprueba que hay alguna cuenta almacenada a través del método
     * comprobarExisteCuenta()
     *
     * Imprime las cuentas existentes (id y nombre y apellidos del titual) y
     * pregunta al usuario que cuenta quiere filtrar.
     *
     * Llama al método de la clase CuentaBancaria buscarCuentas y le pasa el id
     * de la cuenta indicada por el usuario. Ese método se encarga de buscar la
     * posición en la que se encuentra almacenada en el ArrayList la cuenta
     * indicada y la devuelve.
     *
     * A través del método comprobarIndiceCuenta(pasandole el indice) comprueba
     * que es correcto y devuelve una Exception si no lo es.
     *
     * @return indice : devuelve el indice para poder imprimir los datos.
     * @throws InputMismatchException : Lanza una Exception si el valor
     * introducido no es un int
     * @throws Exception : Lanza una Exception si la cuenta seleccionada no
     * existe
     *
     */
    // Métodos para solicitar datos al usuario
    private static int seleccionarCuenta() {

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
            //Captura el mensaje si el ID de la cuenta no existe o si no hay cuentas en el sistema
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

    /**
     * Solicita los atributos "nombre, apellidos y fecha_nac" y construye el
     * objeto Persona titular.
     *
     * @return titular : objeto tipo Persona
     */
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

    /**
     * Solicita al usuario que introduzca el codigo de la cuenta y lo manda a
     * validar. Realiza esta acción hasta que la validación no este ok. Cuando
     * todo esta correcto construye el objeto
     *
     * @return codCuentaCliente : devuelve el objeto de tipo CodigoCuenta.
     */
    private static CodigoCuenta solicitaCodigo() {
        String codCompleto;

        do {
            System.out.println("Introduce el numero de cuenta (20 digitos):");
            codCompleto = teclado.nextLine().replaceAll("\\s", "");
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

    /**
     *
     * @throws Exception : Si no hay ninguna cuenta almacenada lanza la
     * Exception indicada. Si el ArrayList esta vacio.
     */
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

}
