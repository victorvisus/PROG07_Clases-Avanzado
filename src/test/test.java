package test;

import com.cypherstudios.gestionCuenta.CodigoCuenta;
import com.cypherstudios.gestionCuenta.CuentaBancaria;
import com.cypherstudios.gestionCuenta.Persona;

import java.util.ArrayList;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        Persona t1 = new Persona("fer1", "uri1", "20/03/1978");
        CodigoCuenta ccc1 = new CodigoCuenta("01234567890123456789");
        CuentaBancaria c1 = new CuentaBancaria(t1, ccc1, 1000);

        Persona t2 = new Persona("fer2", "uri2", "13/06/2000");
        CodigoCuenta ccc2 = new CodigoCuenta("01234567890123456789");
        CuentaBancaria c2 = new CuentaBancaria(t2, ccc2, 1000);

        Persona t3 = new Persona("fer3", "uri3", "06/12/1956");
        CodigoCuenta ccc3 = new CodigoCuenta("01234567890123456789");
        CuentaBancaria c3 = new CuentaBancaria(t3, ccc3, 1000);
        //CuentaBancaria.imprimirCuentas();

        CuentaBancaria.listarCuentas();

        System.out.println("¿de qué cuenta quieres saber el saldo?"
                + "\nDime el nombre del titular:");
        String nombreTit = consola.nextLine();

        //CuentaBancaria.buscarCuenta(nombreTit);
        System.out.println(CuentaBancaria.buscarCuenta(nombreTit));

        //CuentaBancaria.cuentasClientes.get(2).consultarSaldo(CuentaBancaria.buscarCuenta("fer3"));

        System.out.println("");

    }
}
