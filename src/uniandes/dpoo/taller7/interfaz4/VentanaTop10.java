package uniandes.dpoo.taller7.interfaz4;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import uniandes.dpoo.taller7.modelo.RegistroTop10;

public class VentanaTop10 extends JDialog {

    public VentanaTop10(Frame owner, List<RegistroTop10> top10) {
        super(owner, "Top 10", true);
        setLayout(new BorderLayout());
        setSize(300, 400);
        setLocationRelativeTo(owner);

        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (int i = 0; i < top10.size(); i++) {
            RegistroTop10 registro = top10.get(i);
            listModel.addElement((i + 1) + ". " + registro.darNombre() + " - " + registro.darPuntos());
        }

        JList<String> list = new JList<>(listModel);
        list.setCellRenderer(new Top10Renderer());
        JScrollPane scrollPane = new JScrollPane(list);

        add(scrollPane, BorderLayout.CENTER);
    }

    private static class Top10Renderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setFont(new Font("Arial", Font.BOLD, 14));
            if (index == 0) {
                label.setForeground(Color.GREEN);
            } else if (index == 1) {
                label.setForeground(Color.ORANGE);
            } else if (index == 2) {
                label.setForeground(Color.RED);
            } else {
                label.setForeground(Color.BLACK);
            }
            return label;
        }
    }
}

