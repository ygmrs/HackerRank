import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static long maximumSum(long[] a, long m) {
        long[] modSum=new long[a.length];
        TreeSet<Long> ts=new TreeSet<>();
        long total=0;
        long ans=0;
        for(int i=0;i<a.length;i++){
            total=((total+a[i])%m);
            modSum[i]=total;
            if(total>ans){
                ans=total;
            }
        }
        for(int i=0;i<modSum.length;i++){
            ts.add(modSum[i]);
            Long least=ts.higher(modSum[i]);
            if(least!=null){
                if((m-(least-modSum[i]))>ans)
                    ans=(m-(least-modSum[i]));
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
