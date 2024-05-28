package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {

    private JTextField nombreJugador;
    private JTextField contadorJugadas;

    public PanelInferior() {
        setLayout(new GridLayout(1, 4));

        add(new JLabel("Jugadas:"));
        contadorJugadas = new JTextField("0", 5);
        contadorJugadas.setEditable(false);
        add(contadorJugadas);

        add(new JLabel("Jugador:"));
        nombreJugador = new JTextField(10);
        add(nombreJugador);
    }

    public String getNombreJugador() {
        return nombreJugador.getText();
    }

    public void setNombreJugador(String nombre) {
        nombreJugador.setText(nombre);
    }

    public void setContadorJugadas(int jugadas) {
        contadorJugadas.setText(String.valueOf(jugadas));
    }
}
 	