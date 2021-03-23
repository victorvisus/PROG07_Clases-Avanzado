package com.cypherstudios.gestionCuenta;

public class CuentaBancaria {

    protected Persona titular;
    protected CodigoCuenta codCuentaCliente;
    protected double saldo;


    public CuentaBancaria(Persona titular, CodigoCuenta codigoCuenta, double saldo) {
        this.titular = titular;
        this.codCuentaCliente = codigoCuenta;
        this.saldo = saldo;
    }

//    protected abstract void ingresarEfectivo(double saldo);
//
//    protected abstract void retirarEfectivo(double saldo);

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" + "titular=" + titular.toString() + "\ncodCuentaCliente=" + codCuentaCliente.toString() + "\nsaldo=" + saldo + '}';
    }

}
