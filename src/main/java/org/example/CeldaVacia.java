package org.example;

import javax.swing.*;

public class CeldaVacia implements ICelda {

    private boolean estado;
    protected JButton boton = new  JButton();


    @Override
    public boolean setEstado(boolean estado) {
        this.estado = estado;
        return false;
    }

    @Override
    public boolean getEstado() {
        return false;
    }

    @Override
    public JButton getButton() {
        boton.setSize(70,70);
        return boton;
    }

    @Override
    public String toString() {
        return "CeldaVacia{" +
                "estado=" + estado +
                '}';
    }
}
