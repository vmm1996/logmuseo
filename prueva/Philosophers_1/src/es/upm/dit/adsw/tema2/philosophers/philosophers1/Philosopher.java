package es.upm.dit.adsw.tema2.philosophers.philosophers1;


import java.awt.*;


public class Philosopher
        extends Thread {
    public static final Color THINKING = Color.BLUE;
    public static final Color EATING = Color.RED;

    private final int id;
    private final Ball ball;
    private final Chopstick need1;
    private final Chopstick need2;

    public Philosopher(int id, Ball ball, Chopstick need1, Chopstick need2) {
        this.id = id;
        this.ball = ball;
        this.need1 = need1;
        this.need2 = need2;
    }

    @Override
    public void run() {
        while (true) {
            ball.set(THINKING);
            Nap.random(1000, 3000);

            TestSuite.getBarrier().await();
            need1.take();
            Nap.sleep(500);
            need2.take();

            ball.set(EATING);
            Nap.random(1000, 3000);
            need1.put();
            need2.put();
        }
    }
}
