package com.cypherstudios.gestionCuenta;

import com.cypherstudios.interfaces.IImprimir;
import com.cypherstudios.interfaces.IOperaciones;
import java.util.ArrayList;

public class CuentaBancaria implements IOperaciones, IImprimir {

    protected Persona titular;
    protected CodigoCuenta codCuentaCliente;
    protected double saldo;
    protected int idCuenta;
    private static int contador;

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
     *
     */
    public static void listarCuentas() {
        for (CuentaBancaria aux : cuentasClientes) {
            System.out.println(aux);
        }
    }

    /**
     * Busca la posición de la cuenta con la que queremos operar
     *
     * @return int : número de posición en el que se encuentra. -1 si no existe
     */
    public static int buscarCuenta(String titular) {

        //String titular = "fer1";
        int indice = -1;
        for (int i = 0; i < cuentasClientes.size(); i++) {
            if (cuentasClientes.get(i).titular.getNombre() == titular) {
                indice = i;
            }
        }
        if (indice == -1) {
            System.out.println("La cuenta no existe");
        }

        return indice;

    }

    // Implementación de métodos
    @Override
    public String toString() {
        return "CuentaBancaria{" + "idCuenta= " + this.idCuenta + "\ntitular=" + titular.toString() + "\ncodCuentaCliente=" + codCuentaCliente.toString() + "\nsaldo=" + this.saldo + '}';
    }

    // Interface IOperaciones
    @Override
    public void almacenarCuenta(CuentaBancaria cuenta) {
        cuentasClientes.add(this);
    }

    @Override
    public ArrayList leerCuenta() {
        // Abrá que pasarle algo que identifique la cuenta que queremos leer
        return cuentasClientes;
    }

    //Tienen que recibir el idCuenta o los 4 últimos digitos de la cuenta que se quiera leer
    @Override
    public void ingresarEfectivo() {
        System.out.println("Pendiente implementar");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Pendiente implementar");
    }

    @Override
    public double consultarSaldo(int indice) {

        return cuentasClientes.get(indice).getSaldo();
    }

    //Interface: IImprimir
    @Override
    public String detallesCuenta() {
        // Abrá que pasarle algo que identifique la cuenta que queremos leer
        return "Pendiente implementar";
    }

    @Override
    public void imprimirSaldo(int indice) {

        System.out.println("El saldo de la cuenta Nº "
                + cuentasClientes.get(indice).getIdCuenta() + " es: "
                + consultarSaldo(indice));
    }

}
