package com.cypherstudios.gestionCuenta;

public class CodigoCuenta {

    //Defino las variables para almacenar los datos del número de la cuenta corriente
    private String codEntidad;
    private String codOficina;
    private String digControl;
    private String numCuenta;

    //Atributo número de código cuenta cliente
    private String codCompleto;

    /**
     * --- Constructor del Objeto ---
     *
     * @param codCompleto : Recibe el número de cuenta completo CCC
     *
     * @description Una vez que recibe los datos, llama al método cortarCuenta()
     * para mandar los datos a los atributos correspondientes a las distintas
     * partes del número de cuenta
     */
    public CodigoCuenta(String codCompleto) {
        this.codCompleto = codCompleto;

        cortarCodCuenta(codCompleto);
    }

    /**
     * --- Método que descompone el número de cuenta completo en sus diferentes
     * partes ---
     *
     * @param codCompleto : Recibe el número de cuenta completo
     *
     */
    private void cortarCodCuenta(String codCompleto) {
        this.codEntidad = codCompleto.substring(0, 4);
        this.codOficina = codCompleto.substring(4, 8);
        this.digControl = codCompleto.substring(8, 10);
        this.numCuenta = codCompleto.substring(10, 20);

        this.codCompleto = String.format("%s-%s-%s-%s", codEntidad, codOficina, digControl, numCuenta);
    }

    public String getCodCompleto() {
        return this.codCompleto;
    }

    public void setCodCompleto(String codCompleto) {
        this.codCompleto = codCompleto;
    }

    /* No los necesito, creo
    public String getCodEntidad() {
        return this.codEntidad;
    }

    public String getCodOficina() {
        return codOficina;
    }

    public String getDigControl() {
        return digControl;
    }

    public String getNumCuenta() {
        return numCuenta;
    }
     */
    @Override
    public String toString() {
        //return "CodigoCuenta{" + "codEntidad=" + codEntidad + ", codOficina=" + codOficina + ", digControl=" + digControl + ", numCuenta=" + numCuenta + "\ncodCompleto=" + codCompleto + '}';

        return "\n-+ NÚMERO DE CUENTA ++++++-"
                + "\n----------------------------"
                + "\n+ Entidad .................. " + this.codEntidad
                + "\n+ Oficina .................. " + this.codOficina
                + "\n+ Dígito de control ........ " + this.digControl
                + "\n+ Número de cuenta ......... " + this.numCuenta + "\n";
    }

    public static boolean validarCCC(String codCompleto) {
        if (codCompleto.length() != 20) {
            System.out.println("El código de cuenta es demasiado corto.");
            return false;
        } else if (esNumero(codCompleto)) {
            System.out.println("El código de cuenta solo puede tener caracteres numéricos.");
            return false;
        } else {
            return true;
        }
    }

    private static boolean esNumero(String numero) {
        return ((numero.matches("[+-]?\\d*(\\.\\d+)?") || numero.equals("")) == false);
    }

}
