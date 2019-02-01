import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long largestRectangle(int[] h) {
        Stack<Integer> stack = new Stack<Integer>();
        int max_area = 0;
        int i = 0;
        if(h == null || h.length==0) return 0;
        while(i < h.length){
            if(stack.isEmpty() || h[i]>=h[stack.peek()]){
                stack.push(i);
                i++;
            }else{
                int height = h[stack.pop()];
                int width = stack.isEmpty() ? i : i-stack.peek()-1;
                max_area = Math.max(height * width, max_area);
            }
        }
        while(!stack.isEmpty()){
            int height = h[stack.pop()];
            int width = stack.isEmpty() ? i : i-stack.peek()-1;
            max_area = Math.max(height * width, max_area);
        }
        return max_area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
