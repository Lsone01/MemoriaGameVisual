import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuInicio extends JFrame {
    public MenuInicio() {
        setTitle("Selecciona la Dificultad");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton facil = new JButton("Fácil (4x4)");
        JButton medio = new JButton("Medio (6x4)");
        JButton dificil = new JButton("Difícil (6x6)");

        facil.addActionListener(new NivelListener(4, 4));
        medio.addActionListener(new NivelListener(6, 4));
        dificil.addActionListener(new NivelListener(6, 6));

        add(facil);
        add(medio);
        add(dificil);

        setVisible(true);
    }

    private class NivelListener implements ActionListener {
        private int filas, columnas;

        public NivelListener(int filas, int columnas) {
            this.filas = filas;
            this.columnas = columnas;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            JFrame frame = new JFrame("Juego de Memoria Visual");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(new Tablero(filas, columnas));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }
}
