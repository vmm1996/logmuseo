package es.upm.dit.adsw.tema2.philosophers.philosophers2;

import static es.upm.dit.adsw.tema2.philosophers.philosophers2.Philosopher.THINKING;

public class TestSuite {
    public static void main(String[] args) {
        Screen screen = new Screen("philosophers2", 600, 600);
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

        Chopstick F1 = new Chopstick();
        Chopstick F2 = new Chopstick();
        Chopstick F3 = new Chopstick();
        Chopstick F4 = new Chopstick();
        Chopstick F5 = new Chopstick();

        Monitor monitor = new Monitor();

        Philosopher philo1 = new Philosopher(1, b1, monitor, F1, F2);
        Philosopher philo2 = new Philosopher(2, b2, monitor, F2, F3);
        Philosopher philo3 = new Philosopher(3, b3, monitor, F3, F4);
        Philosopher philo4 = new Philosopher(4, b4, monitor, F4, F5);
        Philosopher philo5 = new Philosopher(5, b5, monitor, F5, F1);
        philo1.start();
        philo2.start();
        philo3.start();
        philo4.start();
        philo5.start();
    }
}
