package exercise3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BreakTie {
     private static Iterator<Integer> createIterator(MyIterators type, List<Integer> candidates) {
        if (type == MyIterators.REBOUND) {
            Iterator<Integer> rIt = new Rebound(candidates);
            return rIt;
        } else {
            Iterator<Integer> cIt = new Circular(candidates);
            return cIt;
        }
    }
    public static Integer winner(int n, int k, MyIterators type) {
        Iterator<Integer> iterator;
        List<Integer> candidates = new ArrayList<>();
        if (k<0)
            throw new IllegalArgumentException();
        else {
            for (int i = 1; i <= n; i++) {
                candidates.add(i);
            }
           
                iterator = createIterator(type, candidates);
            for(int J=0; J<n-1;J++){
                for (int c = 0; c <k ; c++) {
                    iterator.next();
                }
                iterator.remove();
                for (int d=0;d<=candidates.size()-1;d++){
                    System.out.print(candidates.get(d));
                }
                System.out.println();
            }
            return candidates.get(0);
    }
    }
}
