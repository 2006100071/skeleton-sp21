package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import net.sf.saxon.om.Item;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public  static  void  testThreeAddThreeRemove()
    {
      BuggyAList<Integer> b = new BuggyAList<>();
      AListNoResizing<Integer> a = new AListNoResizing<>();
      a.addLast(3);
      a.addLast(4);
      a.addLast(5);
      b.addLast(3);
      b.addLast(4);
      b.addLast(5);
      for (int i = 0; i < 3; i++) {
        int t = a.removeLast();
        int t1 = b.removeLast();
        System.out.println(t +" "+ t1);
        assertEquals(t,t1);
      }

//      assertEquals(a.removeLast(),b.removeLast());
//      assertEquals(a.removeLast(),b.removeLast());
    }
    @Test
    public  static  void  randomizedTest()
    {
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> b = new BuggyAList<>();

      int N = 5000;
      for (int i = 0; i < N; i += 1) {
        int operationNumber = StdRandom.uniform(0, 3);
        if (operationNumber == 0) {
          // addLast
          int randVal = StdRandom.uniform(0, 100);
          L.addLast(randVal);
          b.addLast(randVal);
//          System.out.println("addLast(" + randVal + ")");
        } else if (operationNumber == 1) {
          // size
          int size = L.size();
//          System.out.println("size: " + size);
        }
        else {
          if(L.size() > 0 && b.size() > 0) {
            int randVal = L.getLast();
            int t =  L.removeLast();
            int randVal1 = b.getLast();
            int t1 = b.removeLast();
//            System.out.println("removeLast correct(" + randVal + ")" + t);
//            System.out.println("removeLast(" + randVal + ")" + t1);
            assertEquals(t,t1);
          }

        }
      }
    }
    public static void main(String[] args) {

//      testThreeAddThreeRemove();
      randomizedTest();
    }
}
