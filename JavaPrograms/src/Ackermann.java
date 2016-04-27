import java.util.Stack;

/**
 * Created by Pedro on 17/4/2016.
 */
public class Ackermann {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long ans = ackermann(5, 0);
        long time = System.currentTimeMillis() - start;
        System.out.println("ackerman(4, 1) = " + ans + ". Time: " + time);
    }

    public static long ackermann(long m, long n ) {
        if (m == 0) {
            return n+1;
        } else if (n == 0) {
            return ackermann(m - 1, 1);
        } else {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }

}
