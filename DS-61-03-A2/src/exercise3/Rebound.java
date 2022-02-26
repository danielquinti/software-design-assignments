package exercise3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rebound implements Iterator {

    private int direction = 1;
    private int counter = 0;
    private final List<Integer> candidates;

    public Rebound(List<Integer> candidates) {
        this.candidates = candidates;
    }

    @Override
    public boolean hasNext() {
        return (candidates.size() > 1);
    }

    @Override
    public Integer next() {
        if (direction == 1) {
            if (counter < candidates.size() - 1) {
                counter++;
            } else {
                counter--;
                direction = 0;
            }
        } else {
            if (counter == 0) {
                counter++;
                direction = 1;
            } else {
                counter--;
            }
        }
        return candidates.get(counter);
    }

    @Override
    public void remove() {
        candidates.remove(counter++);
        if (direction == 0) {
            counter=counter++;
        }
    }

}
