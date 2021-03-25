/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class testCelular {
    public static void main(String[] args) {

        Celular c1 = new Celular(1, "j7", "samsung", 6000, 5);
        Celular c2 = new Celular(2, "g2", "motorola", 8000, 2);
        Celular c3 = new Celular(3, "spirit", "lg", 12000, 4);
        Celular c4 = new Celular(4, "s10", "samsung", 24000, 10);

        ArrayList<Celular> listaCelulare = new ArrayList<>();

        listaCelulare.add(c1);
        listaCelulare.add(c2);
        listaCelulare.add(c3);
        listaCelulare.add(c4);

        for (Celular c : listaCelulare) {
            System.out.println(c.toString());
        }

        int idBus = 2;
        int pos = -1;
        for (int i = 0; i < listaCelulare.size(); i++) {
            if (listaCelulare.get(i).getId() == idBus) {
                pos = i;

            }
        }
        if (pos != -1) {
            System.out.println("Se encontro el celular: " + pos);

        } else {
            System.out.println("No lo encontré");
        }

        /*
        int pos = listaCelulare.indexOf(c3);
        System.out.println("pos = " + pos);

        if (pos != -1) {
            System.out.println("Se encontro el celular: " + listaCelulare.get(pos));

        } else {
            System.out.println("No lo encontré");
        }
         */
    }
}
