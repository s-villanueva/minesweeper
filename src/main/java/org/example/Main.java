package org.example;

import org.example.impl.Alto800;
import org.example.impl.BMWM4;
import org.example.impl.IVehiculo;

public class Main {
    public static void main(String[] args) {
        IVehiculo bmwm4 = new BMWM4();
        IVehiculo alto800  = new Alto800();

        if (!(bmwm4 instanceof  BMWM4)){
            System.out.println("BMWM4 no instanciado");
        } else {
            System.out.println("BMWM4 instanciado");
        }

        System.out.println(bmwm4.arrancar("Huella"));
        System.out.println(alto800.arrancar("Llave"));

        System.out.println("ACELERACION ALTO 800: " + alto800.avanzar(15));
        System.out.println("ACELERACIÓN BMW M4: " + bmwm4.avanzar(20));
    }
}