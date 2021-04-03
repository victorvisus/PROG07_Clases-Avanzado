package com.cypherstudios.gestionCuenta;

import java.util.logging.Level;
import java.util.logging.Logger;

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

    //Validaciones
    public static boolean validarCCC(String codCompleto) {
        boolean esValido = true;
        String ent_of;
        String numeros_cuenta;
        String digitos_control_resultado;

        int digito_ent_of, digito_num_cuenta;

        try {
            if (codCompleto.length() != 20) {
                esValido = false;
                throw new Exception("El código de cuenta es demasiado corto.");
            }
            /*
            Hay que dividir el CCC en dos bloques, y sacar un digito por cada bloque
             */
            String aux = codCompleto.substring(8, 10);
            //Hay que poner un 00 al principio de los 8 primeros dígitos de la cuenta (Entidad + Oficina), para tener 10 digitos
            ent_of = "00" + codCompleto.subSequence(0, 8);
            //En otro bloque se guarda el número de cuenta
            numeros_cuenta = codCompleto.substring(10, 20);

            //Pasa cada uno de los bloques a un digito, enviandolos a la función obtenerDigitoControl.
            digito_ent_of = obtenerDigitoControl(ent_of);
            digito_num_cuenta = obtenerDigitoControl(numeros_cuenta);

            //Meto los digitos obtenidos a un String
            digitos_control_resultado = String.valueOf(digito_ent_of) + String.valueOf(digito_num_cuenta);

            if (!digitos_control_resultado.equals(aux)) {
                //Si los digitos no coinciden con los pasados, lanza una excepcion.
                esValido = false;
                throw new Exception("El digito de control no coinciden");
            } else if (esNumero(codCompleto)) {
                //Si el String introducido contiene letras, lanza un error.
                esValido = false;
                throw new Exception("El código de cuenta solo puede tener caracteres numéricos.");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return esValido;
    }

    private static boolean esNumero(String numero) {
        return ((numero.matches("[+-]?\\d*(\\.\\d+)?") || numero.equals("")) == false);
    }

    private static int obtenerDigitoControl(String valor_cuenta) {

        //Estos factores estan definidos de por si
        int[] factores = {1, 2, 4, 8, 5, 10, 9, 7, 3, 6};
        int digito_control = 0;

        int digito_cuenta;
        for (int i = 0; i < valor_cuenta.length(); i++) {
            //Para evitar problemas, se coje un caracter del String, se convierte a char y, éste a int
            digito_cuenta = Integer.parseInt(String.valueOf(valor_cuenta.charAt(i)));

            //Lo multiplica por los factores y se suman
            digito_control += digito_cuenta * factores[i];
        }

        //El número resultante (entre 0 y 9) se hace 11 - el resto de dividirlo entre 11
        digito_control = 11 - (digito_control % 11);

        //Si el resultado es 11, digito se pone a cero Y SI es 10 a uno, para otro resultado se queda como esta
        if (digito_control == 11) {
            digito_control = 0;
        } else if (digito_control == 10) {
            digito_control = 1;
        }
        return digito_control;
    }

}
