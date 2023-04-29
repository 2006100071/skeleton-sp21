package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.List;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    private static double add(int n) {
        SLList<Integer> t = new SLList<>();
        for (int i = 0; i < n; i++) {
            t.addLast(i);
        }
        Stopwatch sw = new Stopwatch();
        for (int i = 0; i < 10000; i++) {
            t.getLast();
        }
        double timeInSeconds = sw.elapsedTime();
        return timeInSeconds;
    }
    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int x = 1000;
        for (int i = 0; i < 8; i++) {
            Ns.addLast(x);
            double timeInSeconds = add(x);
            times.addLast(timeInSeconds);
            opCounts.addLast(10000);
            x *= 2;
        }
        printTimingTable(Ns,times,opCounts);
    }

}
