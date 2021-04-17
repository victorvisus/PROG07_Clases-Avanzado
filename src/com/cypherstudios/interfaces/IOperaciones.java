package com.cypherstudios.interfaces;

import com.cypherstudios.gestionCuenta.CuentaBancaria;
import java.util.ArrayList;

public interface IOperaciones {

    ArrayList<CuentaBancaria> cuentasClientes = new ArrayList<>();

    public abstract void almacenarCuenta(CuentaBancaria cuenta);

    public abstract double ingresarEfectivo(double importe);

    public abstract double retirarEfectivo(double importe) throws Exception;

}
