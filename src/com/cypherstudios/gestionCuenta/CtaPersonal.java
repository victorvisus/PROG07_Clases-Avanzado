package com.cypherstudios.gestionCuenta;

public class CtaPersonal extends CuentaCorriente {

    private double comision;

    public CtaPersonal(Persona titular, CodigoCuenta codigoCuenta, double saldo, double comision) {
        super(titular, codigoCuenta, saldo);
        this.comision = comision;
    }

    public double getComision() {
        return this.comision;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    @Override
    public String toString() {
        return super.toString()
                + "-+++ COMISIÓN POR MANTENIMIENTO .: " + comision + " €/año"
                + "\n----------------------------------------\n";
    }


}
