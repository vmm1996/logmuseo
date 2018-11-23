package es.upm.dit.adsw.tema2.philosophers.philosophers2;


import java.awt.*;

public class Philosopher
        extends Thread {
    public static final Color THINKING = Color.BLUE;
    public static final Color EATING = Color.RED;

    private final int id;
    private final Ball ball;
    private Monitor monitor;
    private final Chopstick need1;
    private final Chopstick need2;

    public Philosopher(int id, Ball ball, Monitor monitor, Chopstick need1, Chopstick need2) {
        this.id = id;
        this.ball = ball;
        this.monitor = monitor;
        this.need1 = need1;
        this.need2 = need2;
    }

    @Override
    public void run() {
        while (true) {
            ball.set(THINKING);
            Nap.random(700, 1000);

            monitor.take(need1, need2);
            ball.set(EATING);
            Nap.random(600, 3000);
            monitor.put(need1, need2);
        }
    }
}
