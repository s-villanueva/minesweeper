package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Frame extends JFrame {

    public JPanel init(Tablero tablero, JPanel panel) {
        JButton b;
        for (int i = 0; i < tablero.tablero.length; i++) {
            for (int j = 0; j < tablero.tablero.length; j++) {
                final int a = i; final int s = j;
                b = tablero.tablero[i][j].getButton();

                b.addActionListener(e -> {
                    ICelda celda = tablero.tablero[a][s];
                    JButton boton = (JButton) e.getSource();
                    if (celda instanceof CeldaVacia) {
                        System.out.println("Vacio");
                        celda.setEstado(true);

                        ArrayList q = tablero.checkSurroundings(a, s);
                        Queue <UbicacionObj> queue = new LinkedList<UbicacionObj>();
                        for (int l = 0; l < q.size(); l++) {
                            queue.add((UbicacionObj) q.get(l));
                        }
                        while (!queue.isEmpty()) {
                            UbicacionObj u = queue.poll();
                            JButton lol = tablero.tablero[u.a][u.b].getButton();
                            lol.setEnabled(false);
                            tablero.checkSurroundings(u.a,u.b);
                        }

                    } else {
                        System.out.println("BOMBA");
                        boton.setText("BOMBA");
                        boton.setBackground(Color.RED);
                        celda.setEstado(true);
                        boton.setEnabled(false);
                    }
                });
                panel.add(b);
            }
        }
        return panel;
    }

    public static void main(String[] args) {
        //Declaración de variables de interfaz
        Tablero tablero = new Tablero();
        JFrame frame = new JFrame();
        JPanel panel = new JPanel(new GridLayout(10, 10));
        Frame frame1 = new Frame();
        //Declaración de parámetros
        frame.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        JPanel p = frame1.init(tablero, panel);
        tablero.print();
        //Declaracion de botones
        frame.add(p);
    }

}
