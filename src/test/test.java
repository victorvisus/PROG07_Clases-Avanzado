package test;

import com.cypherstudios.gestionCuenta.CodigoCuenta;
import com.cypherstudios.gestionCuenta.CtaEmpresa;
import com.cypherstudios.gestionCuenta.CtaPersonal;
import com.cypherstudios.gestionCuenta.CuentaAhorro;
import com.cypherstudios.gestionCuenta.CuentaBancaria;
import com.cypherstudios.gestionCuenta.CuentaCorriente;
import com.cypherstudios.gestionCuenta.Persona;

import java.util.ArrayList;

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        Persona t4 = new Persona("fer4", "uri4", "01/01/1956");
        CodigoCuenta ccc4 = new CodigoCuenta("01234567890123456789");
        CuentaBancaria c4 = new CuentaAhorro(t4, ccc4, 4000, 12.00);

        Persona t5 = new Persona("fer5", "uri5", "23/05/1995");
        CodigoCuenta ccc5 = new CodigoCuenta("01234567890123456789");
        CuentaBancaria c5 = new CtaPersonal(t5, ccc5, 2000, 12);

        Persona t6 = new Persona("fer5", "uri5", "23/05/1995");
        CodigoCuenta ccc6 = new CodigoCuenta("01234567890123456789");
        CuentaBancaria c6 = new CtaEmpresa(t6, ccc6, 20000, 1000, 10, 30);



        //CuentaBancaria.previewCuentas();

        for (CuentaBancaria aux : CuentaBancaria.cuentasClientes) {

            aux.listarCuentas(aux);

        }

        System.out.println("Cuenta Corriente: " + c6.toString());
    }
}
