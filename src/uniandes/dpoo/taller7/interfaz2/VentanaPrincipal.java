package uniandes.dpoo.taller7.interfaz2;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
import uniandes.dpoo.taller7.modelo.Tablero;

public class VentanaPrincipal extends JFrame {

    protected PanelSuperior panelSuperior;
    private PanelDerecha panelDerecha;
    private PanelInferior panelInferior;

    private Tablero tablero;

    public VentanaPrincipal() {
        setTitle("Juego de LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSuperior = new PanelSuperior();
        panelDerecha = new PanelDerecha(this);
        panelInferior = new PanelInferior();
        tablero = new Tablero(5); // Tamaño por defecto del tablero


        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecha, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);

    }

    public void nuevoJuego(int tamaño) {
        tablero = new Tablero(tamaño);
        revalidate();
        repaint();
    }

    public void reiniciarJuego() {
        tablero.reiniciar();
        revalidate();
        repaint();
    }

    public void mostrarTop10() {
        // Aquí deberías implementar la lógica para mostrar el top 10
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
