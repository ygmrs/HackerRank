import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long minTime(long[] machines, long goal) {
        long result = -1;
        long lower = 0;
        long upper = 1000000000000000000L;
        while (lower <= upper) {
            long middle = (lower + upper) / 2;
            long itemNumber = 0;
            for (long machine : machines) {
                itemNumber += middle / machine;
                if (itemNumber > Integer.MAX_VALUE) {
                    itemNumber = Integer.MAX_VALUE;
                }
            }
            if (itemNumber >= goal) {
                result = middle;
                upper = middle - 1;
            } else {
                lower = middle + 1;
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
