package com.cypherstudios.interfaces;

import com.cypherstudios.gestionCuenta.CuentaBancaria;
import java.util.ArrayList;

public interface IOperaciones {

    ArrayList<CuentaBancaria> cuentasClientes = new ArrayList<>();

    public abstract void almacenarCuenta(CuentaBancaria cuenta);

    public abstract ArrayList<CuentaBancaria> leerCuenta();

    //Tienen que recibir el idCuenta o los 4 últimos digitos de la cuenta que se quiera leer
    public abstract void ingresarEfectivo();

    public abstract void retirarEfectivo();

    public double consultarSaldo(int indice);

}
