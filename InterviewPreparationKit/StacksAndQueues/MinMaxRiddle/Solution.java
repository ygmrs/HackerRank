import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long[] riddle(long[] arr) {
        int n = arr.length;
        long[] result = new long[n];
        long[] span = new long[n];

        ArrayDeque<Long> deque = new ArrayDeque<>();
        ArrayDeque<Long> deque1 = new ArrayDeque<>();
        deque1.push(-1L);

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peek() >= arr[i]) {
                deque.pop();
                deque1.pop();
            }
            span[i] = i - deque1.peek() - 1;
            deque.push(arr[i]);
            deque1.push((long) i);
        }

        deque.clear();
        deque1.clear();
        deque1.push((long) n);
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() >= arr[i]) {
                deque.pop();
                deque1.pop();
            }
            span[i] += deque1.peek() - i - 1;
            deque.push(arr[i]);
            deque1.push((long) i);
        }

        for (int i = 0; i < n; i++) {
            result[(int) span[i]] = Math.max(result[(int) span[i]], arr[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            result[i] = Math.max(result[i], result[i + 1]);
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
