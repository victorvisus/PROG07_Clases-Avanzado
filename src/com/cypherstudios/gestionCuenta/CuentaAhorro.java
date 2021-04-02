package com.cypherstudios.gestionCuenta;

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
                + "-+++ TIPO DE INTERÉS ...........: " + tipoInteres + " %"
                + "\n--------------------------------------------\n";
    }

    // Hereda las clases Interface de su "clase padre" CuentaBancaria. //

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

        System.out.println("ID Cuenta: " + aux.getIdCuenta()
                + "; CCC: " + aux.codCuentaCliente.getCodCompleto()
                + "; Titular: " + aux.titular.getNombre() + " " + aux.titular.getApellidos()
                + "; Saldo: " + aux.getSaldo()
                + "; Tipo de Interes: " + this.getTipoInteres()
        );

    }
}
