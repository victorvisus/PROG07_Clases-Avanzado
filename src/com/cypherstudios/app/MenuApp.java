package com.cypherstudios.app;

import static com.cypherstudios.app.AppProg07.teclado;
import com.cypherstudios.gestionCuenta.CuentaBancaria;
import java.util.InputMismatchException;

/**
 *
 * @author Victor
 */
public class MenuApp {

    private static int indice;

    public static void opcion03() {
        try {
            System.out.println("¿de qué cuenta quieres sacar los datos completos?"
                    + "\nDime el ID de la cuenta:");
            int idCuenta = teclado.nextInt();

            indice = CuentaBancaria.buscarCuenta(idCuenta);
            comprobarIndiceCuenta(indice);

            System.out.println(
                    CuentaBancaria.cuentasClientes.get(indice).detallesCuenta(indice)
            );

        } catch (InputMismatchException e) {
            //Limpia el bufer de la clase Scanner, para que no entre en bucle
            teclado.nextLine();

            System.out.println("AVISO: Solo se admiten carácteres numéricos");
        } catch (Exception e) {
            //Captura el mensaje si el ID de la cuenta no existe
            System.out.println(e.getMessage());
        }
    }

    public static void opcion06() {
        try {
            System.out.println("¿de qué cuenta quieres saber el saldo?"
                    + "\nDime el ID de la cuenta:");
            int idCuenta = teclado.nextInt();

            indice = CuentaBancaria.buscarCuenta(idCuenta);
            comprobarIndiceCuenta(indice);

            CuentaBancaria.cuentasClientes.get(indice).consultarSaldo(indice);

        } catch (InputMismatchException e) {
            //Limpia el bufer de la clase Scanner, para que no entre en bucle
            teclado.nextLine();

            System.out.println("AVISO: Solo se admiten carácteres numéricos");
        } catch (Exception e) {
            //Captura el mensaje si el ID de la cuenta no existe
            System.out.println(e.getMessage());
        }
    }

    // Métodos para realizar comprobaciones //
    /**
     * Comprueba que la cuenta seleccionada existe
     *
     * @param indice :
     * @throws Exception :
     */
    private static void comprobarIndiceCuenta(int indice) throws Exception {
        if (indice == -1) {
            throw new Exception("El ID de Cuenta no es válido.\n");
        }
    }
}
