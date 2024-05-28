	package uniandes.dpoo.taller7.interfaz4;
	
	import javax.swing.*;
	import java.awt.*;
	
	public class PanelSuperior extends JPanel {
	
	    private JComboBox<String> comboBox;
	    private JRadioButton facil;
	    private JRadioButton dificil;
	
	    public PanelSuperior() {
	        setLayout(new FlowLayout());
	
	        add(new JLabel("Tama�o:"));
	        comboBox = new JComboBox<>(new String[]{"5", "6", "7"});
	        add(comboBox);
	
	        facil = new JRadioButton("F�cil");
	        dificil = new JRadioButton("Dif�cil");
	        ButtonGroup grupo = new ButtonGroup();
	        grupo.add(facil);
	        grupo.add(dificil);
	        add(facil);
	        add(dificil);
	
	        JButton nuevoButton = new JButton("Nuevo");
	        add(nuevoButton);
	    }
	
	    public String getTama�o() {
	        return (String) comboBox.getSelectedItem();
	    }
	}
