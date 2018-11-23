package es.upm.dit.adsw.tema2.philosophers.philosophers1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private Lock door = new ReentrantLock();

    public void take() {
        door.lock();
        System.out.println("take " + this);
    }

    public void put() {
        System.out.println("put  " + this);
        door.unlock();
    }
}
