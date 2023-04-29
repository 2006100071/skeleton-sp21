package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    private static void add(int n) {
        AList<Integer> t = new AList<>();
        for (int i = 0; i < n; i++) {
            t.addLast(i);
        }
        return;
    }
    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        int x = 1000;
        for (int i = 0; i < 8; i++) {
            Ns.addLast(x);
            Stopwatch sw = new Stopwatch();
            add(x);
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(x);
            x *= 2;
        }

//        times.addLast(0.00);
//        times.addLast(0.01);
//        times.addLast(0.01);
//        times.addLast(0.04);
//        times.addLast(0.10);
//        times.addLast(0.50);
//        times.addLast(1.15);
//        times.addLast(3.74);

        printTimingTable(Ns,times,opCounts);
    }
}
