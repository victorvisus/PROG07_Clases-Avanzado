package com.cypherstudios.interfaces;

import com.cypherstudios.gestionCuenta.CuentaBancaria;

public interface IImprimir {

    public abstract void listarCuentas(CuentaBancaria aux);

    public abstract String detallesCuenta(int indice);

    public void consultarSaldo(int indice);

}
