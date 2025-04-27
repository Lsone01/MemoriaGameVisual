import javax.swing.*;
import java.awt.*;

public class Carta extends JButton {
    private int id;
    private boolean descubierta = false;
    private ImageIcon frente;
    private static ImageIcon reverso = Recursos.cargarImagen("reverso.png");

    public Carta(int id, String rutaImagen) {
        this.id = id;

        // Redimensionar la imagen para que se ajuste mejor al botón
        this.frente = redimensionarImagen(Recursos.cargarImagen(rutaImagen), 80, 80);

        // También redimensionar el reverso (solo una vez como es estático)
        if (reverso != null && reverso.getIconWidth() > 90) {
            reverso = redimensionarImagen(reverso, 80, 80);
        }

        ocultar();
        setPreferredSize(new Dimension(100, 100));

        // Usar bordes más pronunciados con diferentes colores
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 150), 3),
                BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Padding interior

        // Fondo con color que contraste
        setBackground(new Color(230, 230, 250));

        // Desactivar el efecto de "pintado" del foco
        setFocusPainted(false);

        // Asegurar que las imágenes se muestren correctamente
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
    }

    // Método para redimensionar imágenes
    private ImageIcon redimensionarImagen(ImageIcon icono, int ancho, int alto) {
        if (icono == null) return null;
        Image img = icono.getImage();
        Image imgRedim = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
        return new ImageIcon(imgRedim);
    }

    public int getIdCarta() {
        return id;
    }

    public void descubrir() {
        this.setIcon(frente);
        this.setEnabled(true); // Mantenerlo habilitado para ver mejor la imagen
        this.setBorderPainted(true);
        this.setBackground(new Color(255, 255, 220)); // Fondo más claro cuando está descubierta

        // Borde distintivo para cartas descubiertas
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 20, 60), 3),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        descubierta = true;
    }

    public void ocultar() {
        this.setIcon(reverso);
        this.setEnabled(true);
        this.setBorderPainted(true);
        this.setBackground(new Color(230, 230, 250));

        // Restaurar borde original
        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(70, 70, 150), 3),
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));

        descubierta = false;
    }

    public boolean estaDescubierta() {
        return descubierta;
    }
}