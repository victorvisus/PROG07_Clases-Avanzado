package com.cypherstudios.gestionCuenta;

public class CtaEmpresa extends CuentaCorriente {

    private double maxDescubierto;
    private double tipoIntDesc;
    private double comisionDesc;

    public CtaEmpresa(Persona titular, CodigoCuenta codigoCuenta, double saldo,
            double maxDescubierto, double tipoIntDesc, double comisionDesc) {
        super(titular, codigoCuenta, saldo);
        this.maxDescubierto = maxDescubierto;
        this.tipoIntDesc = tipoIntDesc;
        this.comisionDesc = comisionDesc;
    }

    public double getMaxDescubierto() {
        return this.maxDescubierto;
    }

    public void setMaxDescubierto(double maxDescubierto) {
        this.maxDescubierto = maxDescubierto;
    }

    public double getTipoIntDesc() {
        return this.tipoIntDesc;
    }

    public void setTipoIntDesc(double tipoIntDesc) {
        this.tipoIntDesc = tipoIntDesc;
    }

    public double getComisionDesc() {
        return this.comisionDesc;
    }

    public void setComisionDesc(double comisionDesc) {
        this.comisionDesc = comisionDesc;
    }

    @Override
    public String toString() {
        return super.toString()
                + "-+++ MÁX. DESCUBIERTO ...........: " + maxDescubierto + " €\n"
                + "-+++ INTERES POR DESCUBIERTO ....: " + tipoIntDesc + " %\n"
                + "-+++ COMISIÓN POR DESCUBIERTO ...: " + comisionDesc + " €"
                + "\n--------------------------------------------\n";
    }


}
