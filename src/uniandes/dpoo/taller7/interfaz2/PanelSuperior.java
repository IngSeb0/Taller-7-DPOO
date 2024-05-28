package uniandes.dpoo.taller7.interfaz2	;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel {

    private JComboBox<String> comboBox;
    private JRadioButton facil;
    private JRadioButton medio;
    private JRadioButton dificil;

    public PanelSuperior() {
        setLayout(new FlowLayout());

        add(new JLabel("Tamaño:"));
        comboBox = new JComboBox<>(new String[]{"5x5", "6x6", "7x7"});
        add(comboBox);

        add(new JLabel("Dificultad"));
        facil = new JRadioButton("Fácil");
        medio = new JRadioButton("Medio");
        dificil = new JRadioButton("Difícil");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(facil);
        grupo.add(medio);
        grupo.add(dificil);
        add(facil);
        add(medio);
        add(dificil);
    }

    public String getTamaño() {
        return (String) comboBox.getSelectedItem();
    }
}
