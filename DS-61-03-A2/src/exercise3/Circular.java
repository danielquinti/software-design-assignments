package exercise3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Circular implements Iterator {

    private int counter = 0;
    private List<Integer> candidates;

    public Circular(List<Integer> candidates) {
        this.candidates = candidates;
    }


    @Override
    public boolean hasNext() {
        return (candidates.size() > 1);
    }

    @Override
    public Integer next() {
            if (counter<candidates.size()-1)
                counter++;
            else counter=0;
        return candidates.get(counter);
    }
        
    @Override
    public void remove() {
        if(counter==0)
            candidates.remove(candidates.size()-1);
        else 
            candidates.remove(counter-1);
        if((candidates.size()==2)&&(counter==0))
            return;
        else  
            counter--;
    }

   
                  
            
}

