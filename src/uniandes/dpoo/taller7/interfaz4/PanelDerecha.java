package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelDerecha extends JPanel {

    public PanelDerecha(VentanaPrincipal ventana) {
        setLayout(new GridLayout(4, 1));

        JButton nuevoButton = new JButton("NUEVO");
        nuevoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String tamañoStr = ventana.panelSuperior.getTamaño().split("x")[0];
                    int tamaño = Integer.parseInt(tamañoStr);
                    ventana.nuevoJuego(tamaño);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(nuevoButton);

        JButton reiniciarButton = new JButton("REINICIAR");
        reiniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.reiniciarJuego();
            }
        });
        add(reiniciarButton);

        JButton top10Button = new JButton("TOP-10");
        top10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarTop10();
            }
        });
        add(top10Button);

        JButton cambiarJugadorButton = new JButton("CAMBIAR JUGADOR");
        cambiarJugadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombreJugador = JOptionPane.showInputDialog(ventana, "Ingrese el nombre del jugador:");
                    ventana.panelInferior.setNombreJugador(nombreJugador);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        add(cambiarJugadorButton);
    }
}
