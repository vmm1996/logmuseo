package es.upm.dit.adsw.tema2.philosophers.philosophers2;

import java.awt.*;

public class Ball
        implements Screen.Thing {
    private int cx;
    private int cy;
    private int r = 30;
    private Color body = Color.CYAN;

    private final Screen screen;

    public static Ball create(Screen screen) {
        return new Ball(screen);
    }

    private Ball(Screen screen) {
        this.screen = screen;
        screen.add(this);
    }

    public Ball set(Color color) {
        body = color;
        screen.paint();
        return this;
    }

    public Ball setXY(int x0, int y0) {
        cx = x0;
        cy = y0;
        return this;
    }

    public Color getColor() {
        return body;
    }

    public synchronized void paint(Graphics2D g) {
        if (body != null) {
            g.setColor(body);
            g.fillOval(cx - r, cy - r, 2 * r, 2 * r);
        }
        g.setColor(Color.BLACK);
        g.drawOval(cx - r, cy - r, 2 * r, 2 * r);
    }
}
