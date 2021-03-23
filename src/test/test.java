package test;

import com.cypherstudios.gestionCuenta.CodigoCuenta;
import com.cypherstudios.gestionCuenta.CuentaBancaria;
import com.cypherstudios.gestionCuenta.Persona;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);

        /* PRUEBA CREAR UN OBJETO CuentaBancaria Básico */
        System.out.println("Dime el nombre del titular: ");
        String nombre = consola.nextLine();

        System.out.println("Dime apellidos del titular: ");
        String apellidos = consola.nextLine();

        System.out.println("Fecha Nacimiento del titular: ");
        String fecha_nac = consola.nextLine();

        Persona titular = new Persona(nombre, apellidos, fecha_nac);

        String codigoCuenta;
        do {
            System.out.println("Escribe el número de cuenta: ");
            codigoCuenta = consola.nextLine();
            //codCompleto = "01234567890123456789";
        } while (!CodigoCuenta.validarCCC(codigoCuenta));

        CodigoCuenta cuentaCliente = new CodigoCuenta(codigoCuenta);

        System.out.println("Dime el Saldo:");
        double saldo = consola.nextInt();

        CuentaBancaria miCuenta = new CuentaBancaria(titular, cuentaCliente, saldo);

        //System.out.println("Los datos de la cuenta creada son:\n " + miCuenta.toString());

        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(miCuenta);

        for (int i = 0; i < cuentas.size(); i++) {
            System.out.println("Numeros " + cuentas.get(i));
        }

    }
}
