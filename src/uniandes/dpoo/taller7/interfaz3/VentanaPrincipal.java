package uniandes.dpoo.taller7.interfaz3;


import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;

import uniandes.dpoo.taller7.modelo.Tablero;

public class VentanaPrincipal extends JFrame {

    public PanelSuperior panelSuperior;
    private PanelDerecha panelDerecha;
    private PanelInferior panelInferior;
    private PanelTablero panelTablero;
    private Tablero tablero;

    public VentanaPrincipal() {
        setTitle("Lights Out");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSuperior = new PanelSuperior();
        panelDerecha = new PanelDerecha(this);
        panelInferior = new PanelInferior();
        tablero = new Tablero(5);
        panelTablero = new PanelTablero(tablero);
        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecha, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelTablero, BorderLayout.CENTER);
    }

    public void nuevoJuego(int tamaño) {
        tablero = new Tablero(tamaño);
        panelTablero.setTablero(tablero);
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
