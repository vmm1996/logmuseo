package es.upm.dit.adsw.tema2.philosophers.philosophers1;

public class Barrier {
    private final int needed;
    private int ready;

    public Barrier(int needed) {
        this.needed = needed;
        this.ready = 0;
    }

    public synchronized void await() {
        ready++;
        if (ready < needed) {
            waiting();
        } else {
            ready = 0;
            notifyAll();
        }
    }

    private void waiting() {
        try {
            wait();
        } catch (InterruptedException ignored) {
        }
    }
}
