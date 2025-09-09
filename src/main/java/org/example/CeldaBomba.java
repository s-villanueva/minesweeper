package org.example;

import javax.swing.*;

public class CeldaBomba implements ICelda {

    private boolean estado;
    protected JButton boton = new  JButton();

    @Override
    public boolean setEstado(boolean estado) {
        this.estado = estado;
        return estado;
    }

    public JButton getButton() {
        boton.setSize(70,70);
        return boton;
    }

    @Override
    public boolean getEstado() {
        return false;
    }

    public String explosion (){
        this.estado = true;

        return "Explotado";
    }

    @Override
    public String toString() {
        return "CeldaBomba{" +
                "estado=" + estado +
                '}';
    }
}
