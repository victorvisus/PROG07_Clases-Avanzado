package com.cypherstudios.interfaces;

import com.cypherstudios.gestionCuenta.CuentaBancaria;
import java.util.ArrayList;

public interface IOperaciones {

    ArrayList<CuentaBancaria> cuentasClientes = new ArrayList<>();

    public abstract void almacenarCuenta(CuentaBancaria cuenta);

    public abstract void ingresarEfectivo();

    public abstract void retirarEfectivo();


}
