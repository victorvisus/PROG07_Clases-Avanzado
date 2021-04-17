package com.cypherstudios.gestionCuenta;

import com.cypherstudios.interfaces.IImprimir;
import com.cypherstudios.interfaces.IOperaciones;

public abstract class CuentaBancaria implements IOperaciones, IImprimir {

    protected Persona titular;
    protected CodigoCuenta codCuentaCliente;
    protected double saldo;
    protected int idCuenta;
    private static int contador;

    /**
     * Constructor de Clase. Una vez instanciada la clase, llama al método que
     * se encarga de almacenar en el ArrayList el objeto que se cree
     *
     * @param titular : Objeto de tipo Persona, recibe nombre, apellidos y
     * fecha_nac
     * @param codigoCuenta : Tipo CodigoCuenta, recibe el número de cuenta.
     * @param saldo : double, recibe el saldo inicial de la cuenta.
     */
    public CuentaBancaria(Persona titular, CodigoCuenta codigoCuenta, double saldo) {
        this.titular = titular;
        this.codCuentaCliente = codigoCuenta;
        this.saldo = saldo;
        this.idCuenta = ++CuentaBancaria.contador;

        almacenarCuenta(this);
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getIdCuenta() {
        return this.idCuenta;
    }

    // Métodos de la Clase CuentaBancaria
    /**
     * Imprime una lista de todas las cuentas almacenadas en el Arraylist. Es un
     * método de clase porque no opera con ninguna instancia en concreto.
     *
     * Mediante un bucle for each recorre el ArrayList extrayendo los datos
     * indicados.
     *
     */
    public static void previewCuentas() {
        System.out.println("En el sistema existen las siguientes cuentas:");

        for (CuentaBancaria aux : cuentasClientes) {
            //System.out.println(aux);
            System.out.println("ID Cuenta: " + aux.getIdCuenta()
                    + " - Titular: " + aux.titular.getNombre() + " " + aux.titular.getApellidos()
            );
        }
    }

    /**
     * Busca la posición de la cuenta con la que queremos operar. Es static por
     * que no pertenece a ninguna instancia, si no que es un método de clase
     *
     * @param idCuenta: recibe el ID de la cuenta con la que se quiere operar.
     * @return int : número de posición en el que se encuentra. -1 si no existe
     */
    public static int buscarCuenta(int idCuenta) {
        //String titular = "fer1";
        int indice = -1;
        for (int i = 0; i < cuentasClientes.size(); i++) {
            if (cuentasClientes.get(i).getIdCuenta() == idCuenta) {
                indice = i;
            }
        }

        return indice;
    }

    protected boolean comprobarSaldo(double saldo, double importe) {
        if (saldo == 0 || importe > saldo) {
            System.out.println("Operación no disponible. "
                    + "\nNo tiene suficiente saldo disponible."
                    + "\nSu saldo actual es: " + saldo);
            return false;
        } else {
            return true;
        }

    }

    // Implementación de métodos //
    @Override
    public String toString() {

        return "\n-+++++  ID de la cuenta: " + this.idCuenta + " +++++-"
                + "\n---------------------------------"
                + titular.toString()
                + codCuentaCliente.toString()
                + "\n--------------------------------------------\n"
                + "-+++ SALDO DISPONIBLE .....: " + this.saldo + " € +++++-"
                + "\n--------------------------------------------\n";
    }

    // Interface IOperaciones
    @Override
    public void almacenarCuenta(CuentaBancaria cuenta) {
        cuentasClientes.add(this);
    }

    /**
     * Realiza la operación de ingresar saldo en la cuenta
     *
     * @param importe
     * @return double : devuelve el saldo después de realizar la operación
     */
    @Override
    public double ingresarEfectivo(double importe) {
        double saldoAnt = this.getSaldo();
        double saldoAct = saldoAnt + importe;
        this.setSaldo(saldoAct);

        return saldoAct;
    }

    /**
     * Realiza la operación de retirar saldo en la cuenta.
     *
     * Antes de realizar esta acción comprueba si el saldo disponible en la
     * cuenta es suficiente
     *
     * @param importe
     * @return double : devuelve el saldo después de realizar la operación
     */
    @Override
    public double retirarEfectivo(double importe) {
        System.out.println("Pendiente implementar");

        boolean error;
        double saldoDisp;
        double saldoAct = 0;
        do {
            try {
                error = false;
                //importe = introducirImporte();
                saldoDisp = this.getSaldo();

                if (comprobarSaldo(saldoDisp, importe)) {
                    saldoAct = saldoDisp - importe;
                    this.setSaldo(saldoAct);

//                    System.out.println("El saldo actual de la cuenta es: "
//                            + this.getSaldo());
                }

            } catch (Exception e) {
                //Captura el mensaje si no hay o no hay suficiente saldo.
                System.out.println(e.getMessage());
                error = true;
            }
        } while (error);

        return saldoAct;
    }

    //Interface: IImprimir
    /**
     * Imprime el saldo de la cuenta de la cual recibe
     *
     * @param indice
     */
    @Override
    public void consultarSaldo(int indice) {
        System.out.println("El saldo de la cuenta con ID "
                + cuentasClientes.get(indice).getIdCuenta() + " es: "
                + CuentaBancaria.cuentasClientes.get(indice).getSaldo() + " €"
        );
    }

    @Override
    public String detallesCuenta(int indice) {
        // Abrá que pasarle algo que identifique la cuenta que queremos leer
        return cuentasClientes.get(indice).toString();
    }

    @Override
    public void listarCuentas(CuentaBancaria aux) {

        //aux = (CuentaBancaria) aux;
        System.out.println("ID Cuenta: " + aux.getIdCuenta()
                + "; CCC: " + aux.codCuentaCliente.getCodCompleto()
                + "; Titular: " + aux.titular.getNombre() + " " + aux.titular.getApellidos()
                + "; Saldo: " + aux.getSaldo()
        );
    }

}
