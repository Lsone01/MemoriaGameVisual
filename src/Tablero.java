import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.ArrayList;

public class Tablero extends JPanel {
    private Carta primeraCarta = null;
    private Carta segundaCarta = null;
    private Timer timer;
    private int filas, columnas;

    public Tablero(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        setLayout(new GridLayout(filas, columnas, 10, 10));
        setBackground(new Color(245, 245, 245));
        inicializarCartas();
        timer = new Timer(800, e -> verificarCartas());
        timer.setRepeats(false);
    }

    private void inicializarCartas() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (int i = 1; i <= (filas * columnas) / 2; i++) {
            ids.add(i);
            ids.add(i);
        }
        Collections.shuffle(ids);

        for (int id : ids) {
            Carta carta = new Carta(id, "img" + id + ".png");
            carta.addActionListener(e -> manejarTurno(carta));
            add(carta);
        }
    }

    private void manejarTurno(Carta carta) {
        if (primeraCarta == null) {
            primeraCarta = carta;
            primeraCarta.descubrir();
        } else if (segundaCarta == null && carta != primeraCarta) {
            segundaCarta = carta;
            segundaCarta.descubrir();
            timer.start();
        }
    }

    private void verificarCartas() {
        if (primeraCarta.getIdCarta() != segundaCarta.getIdCarta()) {
            primeraCarta.ocultar();
            segundaCarta.ocultar();
        }
        primeraCarta = null;
        segundaCarta = null;
        if (juegoTerminado()) {
            int opcion = JOptionPane.showConfirmDialog(this, "¡Ganaste! ¿Jugar de nuevo?", "¡Felicidades!", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {
                JFrame ventana = (JFrame) SwingUtilities.getWindowAncestor(this);
                ventana.dispose();
                MemoriaGame.main(null);
            } else {
                System.exit(0);
            }
        }
    }

    private boolean juegoTerminado() {
        for (Component c : getComponents()) {
            if (c instanceof Carta && !((Carta) c).estaDescubierta()) {
                return false;
            }
        }
        return true;
    }
}
