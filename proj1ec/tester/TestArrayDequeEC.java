package tester;
import static org.junit.Assert.*;

import edu.princeton.cs.introcs.StdRandom;
import org.junit.Test;
import student.StudentArrayDeque;
public class TestArrayDequeEC {
    @Test
    public  void  testArray()
    {
        StudentArrayDeque<Integer>t1 = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer>t2 = new ArrayDequeSolution<Integer>();
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                t1.addLast(i);
                t2.addLast(i);
            } else {
                t1.addFirst(i);
                t2.addFirst(i);
            }
        }

        t1.printDeque();
        t2.printDeque();

        for (int i = 0; i < 10; i++) {
            double numberBetweenZeroAndOne = StdRandom.uniform();

            if (numberBetweenZeroAndOne < 0.5) {
                Integer x = t1.removeFirst();
                Integer y = t2.removeFirst();
                System.out.println(x + " " + y);
                assertEquals(x,y);
            } else {
                Integer x = t1.removeLast();
                Integer y = t2.removeLast();
                System.out.println(x + " " + y);
                assertEquals(x,y);
            }
        }


        t1.printDeque();
        t2.printDeque();

    }
}
