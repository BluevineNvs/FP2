import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AnimatedRuleta extends JPanel {
    private final String[] categorias = {
        "Fruits", "Animals", "Colors", "Actions", "Professions"
    };
    private final Color[] colores = {
        new Color(255, 182, 193), new Color(176, 224, 230), new Color(255, 228, 196), 
        new Color(152, 251, 152), new Color(221, 160, 221)
    };
    private double angulo = 0;
    private final Random random = new Random();
    private Timer timer;
    private double currentSpeed;
    private final double segmentSize;
    private double deceleration;

    public AnimatedRuleta() {
        setPreferredSize(new Dimension(800, 600));
        segmentSize = 360.0 / categorias.length;
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (Math.pow(evt.getX() - 250, 2) + Math.pow(evt.getY() - 300, 2) <= 1600) {
                    startSpinning();
                }
            }
        });

        timer = new Timer(16, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angulo += currentSpeed;
                angulo %= 360;
                currentSpeed = Math.max(0, currentSpeed - deceleration);
                repaint();

                if (currentSpeed < 0.01) {
                    currentSpeed = 0;
                    timer.stop();
                }
            }
        });
    }

    private void startSpinning() {
        currentSpeed = 10 + random.nextDouble() * 10; // Velocidad inicial aleatoria entre 10 y 20
        double totalRotation = 1440 + random.nextDouble() * 1440; // Entre 4 y 8 vueltas completas
        deceleration = (currentSpeed * currentSpeed) / (2 * totalRotation);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int radio = 230;

        // Dibujar ruleta
        g2d.translate(250, 300);
        for (int i = 0; i < categorias.length; i++) {
            g2d.setColor(colores[i]);
            g2d.fillArc(-radio, -radio, 2 * radio, 2 * radio, i * 360 / categorias.length - (int)angulo, 360 / categorias.length);
        }

        // Dibujar botón central
        g2d.setColor(Color.WHITE);
        g2d.fillOval(-40, -40, 80, 80);
        g2d.setColor(Color.BLACK);
        g2d.drawOval(-40, -40, 80, 80);
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        g2d.drawString("SPIN", -20, 6);

        // Dibujar flecha desde arriba apuntando a la ruleta
        int[] xPoints = {0, -10, 10};
        int[] yPoints = {-radio - 10, -radio - 20, -radio - 20};
        g2d.setColor(Color.BLACK);
        g2d.fillPolygon(xPoints, yPoints, 3);

        // Dibujar tabla
        g2d.translate(-250, -300);
        drawTable(g2d);
    }

    private void drawTable(Graphics2D g2d) {
        int startX = 550;
        int startY = 50;
        int rowHeight = 30;
        int colorBoxWidth = 20;
        int padding = 10;

        g2d.setFont(new Font("Arial", Font.PLAIN, 14));
        FontMetrics fm = g2d.getFontMetrics();

        // Dibujar borde de la tabla
        g2d.drawRect(startX - 5, 45, 200, categorias.length * rowHeight + 40);

        // Dibujar título
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        String titulo = "Categories";
        int tituloWidth = g2d.getFontMetrics().stringWidth(titulo);
        g2d.drawString(titulo, startX + (200 - tituloWidth) / 2, startY + 20);
        startY += 30;

        // Dibujar filas
        for (int i = 0; i < categorias.length; i++) {
            // Dibujar cuadro de color
            g2d.setColor(colores[i]);
            g2d.fillRect(startX, startY, colorBoxWidth, colorBoxWidth);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(startX, startY, colorBoxWidth, colorBoxWidth);

            // Dibujar nombre de categoría
            g2d.setFont(new Font("Arial", Font.PLAIN, 14));
            g2d.drawString(categorias[i], startX + colorBoxWidth + padding, startY + fm.getAscent());

            startY += rowHeight;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ruleta Colorida");
        AnimatedRuleta ruleta = new AnimatedRuleta();
        frame.add(ruleta);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}




