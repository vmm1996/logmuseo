package es.upm.dit.adsw.tema2.philosophers.philosophers2;

import java.util.HashSet;
import java.util.Set;

public class Monitor {
    private Set<Chopstick> busy = new HashSet<>();

    public synchronized void take(Chopstick c1, Chopstick c2) {
        while (busy.contains(c1) || busy.contains(c2))
            waiting();
        busy.add(c1);
        busy.add(c2);
    }

    public synchronized void put(Chopstick c1, Chopstick c2) {
        busy.remove(c1);
        busy.remove(c2);
        notifyAll();
    }

    private void waiting() {
        try {
            wait();
        } catch (InterruptedException ignored) {
        }
    }
}
