package org.example;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    Random rand = new Random();
    ArrayList ubicacion = new ArrayList<UbicacionObj>();
    protected ICelda[][] tablero;

    public Tablero() {
        tablero = new ICelda[10][10];
        init();
    }

    public void init (){
        int count = 0;
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (rand.nextInt(2) == 1 && count < 25){
                    tablero[i][j] = new CeldaBomba();
                    count++;
                } else {
                    tablero[i][j] = new CeldaVacia();
                }
            }
        }
    }

    public void show(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] instanceof CeldaVacia) {
                    System.out.print(tablero[i][j] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.print();
    }

    public ArrayList checkSurroundings(int a, int b){
        for (int i = -1 ; i <= 1; i++) {
            for (int j = -1 ; j <= 1; j++) {
                if (tablero[a+i][b+j]  instanceof CeldaVacia) {
                    UbicacionObj u = new UbicacionObj(a + i, b + j);
                    ubicacion.add(u);
                }
            }
        }
        return ubicacion;
    }

    public void print() {
        // Itera sobre cada fila (coordenada i)
        for (int i = 0; i < tablero.length; i++) {
            // Itera sobre cada columna de la fila actual (coordenada j)
            for (int j = 0; j < tablero[i].length; j++) {
                // Comprueba el tipo de celda en la posición [i][j]
                if (tablero[i][j] instanceof CeldaBomba) {
                    // Si es una bomba, imprime 'B'
                    System.out.print("B ");
                } else {
                    // Si no es una bomba (es una CeldaVacia), imprime '.'
                    System.out.print(". ");
                }
            }
            // Al final de cada fila, imprime un salto de línea para pasar a la siguiente
            System.out.println();
        }
    }
}
