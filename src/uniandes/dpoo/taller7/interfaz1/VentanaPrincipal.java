package uniandes.dpoo.taller7.interfaz1;


import javax.swing.*;

import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
import uniandes.dpoo.taller7.modelo.Tablero;

public class VentanaPrincipal extends JFrame {



    public VentanaPrincipal() {
        setTitle("Juego de LightsOut");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        
    }

    
    public static void main(String[] args) {
        FlatLightLaf.install();
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
