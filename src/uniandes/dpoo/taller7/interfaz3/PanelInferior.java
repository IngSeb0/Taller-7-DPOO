package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;

public class PanelInferior extends JPanel {

    private JTextField nombreJugador;

    public PanelInferior() {
        setLayout(new FlowLayout());

        add(new JLabel("Jugador:"));
        nombreJugador = new JTextField(10);
        add(nombreJugador);
    }

    public String getNombreJugador() {
        return nombreJugador.getText();
    }
}
