/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cypherstudios.gestionCuenta;

import com.cypherstudios.interfaces.*;

/**
 *
 * @author Victor
 */
public class CuentaAhorro extends CuentaBancaria {

    private double tipoInteres;

    public CuentaAhorro(Persona titular, CodigoCuenta codigoCuenta,
            double saldo, double tipoInteres) {

        super(titular, codigoCuenta, saldo);
        this.tipoInteres = tipoInteres;

        //almacenarCuenta(this);
    }

    public double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String toString() {
        return super.toString()
                + "-+++ TIPO DE INTERÉS ......: " + tipoInteres + " % ++-"
                + "\n----------------------------------------\n";
    }

//    // Hereda IOperaciones de CuentaBancaria
//    @Override
//    public void almacenarCuenta(CuentaBancaria cuenta) {
//        cuentasClientes.add(this);
//    }
//
//    //Tienen que recibir el idCuenta o los 4 últimos digitos de la cuenta que se quiera leer
//    @Override
//    public void ingresarEfectivo() {
//        System.out.println("Pendiente implementar");
//    }
//
//    @Override
//    public void retirarEfectivo() {
//        System.out.println("Pendiente implementar");
//    }
//
//    //Hereda: IImprimir de CuentaBancaria
//    /**
//     *
//     * @param indice
//     */
////    @Override
////    public void consultarSaldo(int indice) {
////        System.out.println("El saldo de la cuenta con ID "
////                + cuentasClientes.get(indice).getIdCuenta() + " es: "
////                + CuentaAhorro.cuentasClientes.get(indice).getSaldo() + " €"
////        );
////
////    }

    @Override
    public String detallesCuenta(int indice) {
        // Abrá que pasarle algo que identifique la cuenta que queremos leer
        return cuentasClientes.get(indice).toString();
    }

    public double verCuenta() {
        return this.tipoInteres;
    }

    /**
     * PREGUNTA: No estoy seguro que esto sea Polimorfismo
     *
     * @param aux
     */
    @Override
    public void listarCuentas(CuentaBancaria aux) {

//        CuentaAhorro ca1;
//        double interes = 0d;
//        if (aux instanceof CuentaAhorro) {
//            ca1 = (CuentaAhorro) aux;
//            interes = ((CuentaAhorro) aux).getTipoInteres();
//        }

        System.out.println("ID Cuenta: " + aux.getIdCuenta()
                + "; CCC: " + aux.codCuentaCliente.getCodCompleto()
                + "; Titular: " + aux.titular.getNombre() + " " + aux.titular.getApellidos()
                + "; Saldo: " + aux.getSaldo()
                + "; Tipo de Interes: " + this.getTipoInteres()
        );

    }
}
