package com.cypherstudios.gestionCuenta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Victor
 */
public abstract class CuentaCorriente extends CuentaBancaria {

    /**
     * HashMap:
     * <p>
     * Para comprobar que existe una clave: nombreHashMap.containsKey(clave)</p>
     * <p>
     * Para añadir: nombreHashMap.put(clave, valor)</p>
     * <p>
     * Para sacar el valor de una clave: nombreHashMap.get(clave)</p>
     * <p>
     * Para imprimir el contenido: for (String p : nombreHashMap.keySet()) {
     * valor = nombreHashMap.get(clave); System.out.println("Clave: " + p + ",
     * Valor: " + valor); }
     */
    protected HashMap<Integer, String> entidadesAuth = new HashMap<>();

    public CuentaCorriente(Persona titular, CodigoCuenta codigoCuenta, double saldo) {
        super(titular, codigoCuenta, saldo);

        //Construyo el hashmap en en el constructor de la clase.
        entidadesAuth.put(1, "Ibercaja");
        entidadesAuth.put(2, "BBVA");
        entidadesAuth.put(3, "ING");
        entidadesAuth.put(4, "Banco Popular");
        entidadesAuth.put(5, "Bankia");
    }

    public HashMap<Integer, String> getEntidadesAuth() {
        return this.entidadesAuth;
    }

    // Hereda las clases Interface de su "clase padre" CuentaBancaria. //
    @Override
    public String toString() {
        return super.toString()
                + "-+++ ENTIDAS AUTORIZADAS ..: " + printEntidadesAuth()
                + "\n----------------------------------------\n";
    }

    protected ArrayList printEntidadesAuth() {
        ArrayList<String> listaEntidadesAuth = new ArrayList<>();

        for (int p : this.entidadesAuth.keySet()) {
            listaEntidadesAuth.add("\n" + entidadesAuth.get(p));
        }

        return listaEntidadesAuth;
    }
}
