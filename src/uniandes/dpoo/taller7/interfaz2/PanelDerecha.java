package uniandes.dpoo.taller7.interfaz2;



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
                ventana.nuevoJuego(Integer.parseInt(ventana.panelSuperior.getTamaño().split("x")[0]));
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
        add(cambiarJugadorButton);
    }
}
