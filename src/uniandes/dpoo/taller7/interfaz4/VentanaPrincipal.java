package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import uniandes.dpoo.taller7.modelo.RegistroTop10;
import uniandes.dpoo.taller7.modelo.Tablero;
import uniandes.dpoo.taller7.modelo.Top10;

public class VentanaPrincipal extends JFrame {

    protected PanelSuperior panelSuperior;
    private PanelDerecha panelDerecha;
    public PanelInferior panelInferior;
    private PanelTablero panelTablero;
    private Tablero tablero;
    private Top10 top10;

    public VentanaPrincipal() {
        setTitle("Juego de LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        panelSuperior = new PanelSuperior();
        panelDerecha = new PanelDerecha(this);
        panelInferior = new PanelInferior();
        tablero = new Tablero(5); // Tamaño por defecto del tablero
        panelTablero = new PanelTablero(tablero);

        top10 = new Top10(); // Inicializa el Top10

        add(panelSuperior, BorderLayout.NORTH);
        add(panelDerecha, BorderLayout.EAST);
        add(panelInferior, BorderLayout.SOUTH);
        add(panelTablero, BorderLayout.CENTER);
    }

    public void nuevoJuego(int tamaño) {
        tablero = new Tablero(tamaño);
        panelTablero.setTablero(tablero);
        panelInferior.setContadorJugadas(0); // Reinicia el contador de jugadas
        revalidate();
        repaint();
    }

    public void reiniciarJuego() {
        tablero.reiniciar();
        panelTablero.setTablero(tablero);
        panelInferior.setContadorJugadas(0); // Reinicia el contador de jugadas
        revalidate();
        repaint();
    }
    public void actualizarJugadas() {
        panelInferior.setContadorJugadas(tablero.darJugadas());
    }
    public void mostrarTop10() {
        List<RegistroTop10> listaTop10 = new ArrayList<>(top10.darRegistros());
        VentanaTop10 ventanaTop10 = new VentanaTop10(this, listaTop10);
        ventanaTop10.setVisible(true);
    }

    public static void main(String[] args) {
        FlatLightLaf.install();
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
