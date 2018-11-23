package es.upm.dit.adsw.tema2.philosophers.philosophers1;

import static es.upm.dit.adsw.tema2.philosophers.philosophers1.Philosopher.THINKING;

import java.awt.Color;

public class TestSuite {

    private static Barrier barrier;
  //  public static final Color THINKING = Color.BLUE;
   // public static final Color EATING = Color.RED;
    public static void main(String[] args) {
        Screen screen = new Screen("philosophers1", 600, 600);
        double r = 100;
        double phi = 0;
        Ball b1 = Ball.create(screen).set(THINKING)
                .setXY((int) (300 + r * Math.cos(phi)), (int) (300 + r * Math.sin(phi)));
        phi += 2 * Math.PI / 5;
        Ball b2 = Ball.create(screen).set(THINKING)
                .setXY((int) (300 + r * Math.cos(phi)), (int) (300 + r * Math.sin(phi)));
        phi += 2 * Math.PI / 5;
        Ball b3 = Ball.create(screen).set(THINKING)
                .setXY((int) (300 + r * Math.cos(phi)), (int) (300 + r * Math.sin(phi)));
        phi += 2 * Math.PI / 5;
        Ball b4 = Ball.create(screen).set(THINKING)
                .setXY((int) (300 + r * Math.cos(phi)), (int) (300 + r * Math.sin(phi)));
        phi += 2 * Math.PI / 5;
        Ball b5 = Ball.create(screen).set(THINKING)
                .setXY((int) (300 + r * Math.cos(phi)), (int) (300 + r * Math.sin(phi)));

        barrier = new Barrier(5);

        Chopstick F1 = new Chopstick();
        Chopstick F2 = new Chopstick();
        Chopstick F3 = new Chopstick();
        Chopstick F4 = new Chopstick();
        Chopstick F5 = new Chopstick();

        Philosopher philo1 = new Philosopher(1, b1, F1, F2);
        Philosopher philo2 = new Philosopher(2, b2, F2, F3);
        Philosopher philo3 = new Philosopher(3, b3, F3, F4);
        Philosopher philo4 = new Philosopher(4, b4, F4, F5);
        Philosopher philo5 = new Philosopher(5, b5, F5, F1);
        philo1.start();
        philo2.start();
        philo3.start();
        philo4.start();
        philo5.start();
    }

    public static Barrier getBarrier() {
        return barrier;
    }
}
