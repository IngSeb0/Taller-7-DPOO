package uniandes.dpoo.taller7.interfaz3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import uniandes.dpoo.taller7.modelo.Tablero;

public class PanelTablero extends JPanel {

    private Tablero tablero;

    public PanelTablero(Tablero tablero) {
        this.tablero = tablero;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int click_x = e.getX();
                int click_y = e.getY();
                int[] casilla = convertirCoordenadasACasilla(click_x, click_y);
                tablero.jugar(casilla[0], casilla[1]);
                repaint();
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
                    g2d.setColor(Color.YELLOW);
                } else {
                    g2d.setColor(Color.GRAY);
                }
                g2d.fillRoundRect(j * anchoCasilla, i * altoCasilla, anchoCasilla, altoCasilla, 20, 20);
            }
        }
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
