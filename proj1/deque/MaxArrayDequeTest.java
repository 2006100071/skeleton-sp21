package deque;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;

import static org.junit.Assert.*;

public class MaxArrayDequeTest {
    @Test
    public void addIsEmptySizeTest() {
        Comparator<Integer>a = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer x = 0;
                if (o1 > o2)
                    x = 1;
                return x;
            }
        };
        MaxArrayDeque<Integer> p = new MaxArrayDeque<>(a);
        for (int i = 0; i < 10; i++) {
            p.addFirst(i);
        }
        p.printDeque();
        Integer x = p.max();
        System.out.println(x);

    }
}
