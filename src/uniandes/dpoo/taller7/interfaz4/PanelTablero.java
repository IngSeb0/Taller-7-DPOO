package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelTablero extends JPanel {

    private Tablero tablero;
    private int[][] cantidades;

    public PanelTablero(Tablero tablero) {
        this.tablero = tablero;
        int tamaño = tablero.darTablero().length;
        cantidades = new int[tamaño][tamaño];
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int click_x = e.getX();
                int click_y = e.getY();
                int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
                if (casilla[0] < tablero.darTablero().length && casilla[1] < tablero.darTablero().length) {
                    cantidades[casilla[0]][casilla[1]]++;
                    tablero.jugar(casilla[0], casilla[1]);
                    repaint();
                }
            }
        });
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        int ladoTablero = tablero.darTablero().length;
        int altoCasilla = getHeight() / ladoTablero;
        int anchoCasilla = getWidth() / ladoTablero;
        int fila = y / altoCasilla;
        int columna = x / anchoCasilla;
        return new int[]{fila, columna};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int ladoTablero = tablero.darTablero().length;
        int altoCasilla = getHeight() / ladoTablero;
        int anchoCasilla = getWidth() / ladoTablero;

        for (int i = 0; i < ladoTablero; i++) {
            for (int j = 0; j < ladoTablero; j++) {
                if (tablero.darTablero()[i][j]) {
                    g2d.setPaint(new GradientPaint(0, 0, Color.YELLOW, anchoCasilla, altoCasilla, Color.ORANGE));
                } else {
                    g2d.setPaint(new GradientPaint(0, 0, Color.DARK_GRAY, anchoCasilla, altoCasilla, Color.BLACK));
                }
                g2d.fillRoundRect(j * anchoCasilla, i * altoCasilla, anchoCasilla, altoCasilla, 20, 20);
                g2d.setColor(Color.BLACK);
                g2d.drawRoundRect(j * anchoCasilla, i * altoCasilla, anchoCasilla, altoCasilla, 20, 20);
                g2d.setColor(Color.WHITE);
                g2d.drawString(String.valueOf(cantidades[i][j]), j * anchoCasilla + 10, i * altoCasilla + 20);
            }
        }
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
        int tamaño = tablero.darTablero().length;
        cantidades = new int[tamaño][tamaño]; // Resetear cantidades
        repaint();
    }
}
