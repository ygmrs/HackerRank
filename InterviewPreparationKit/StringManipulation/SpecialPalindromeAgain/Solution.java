import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class Point{ char text; long counter;
        Point(char t, long c){
            text = t;
            counter = c;
        }
    }
    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
        long palindromeCount = 0L;
        long equalCounter = 1L;
        List<Point> countList = new ArrayList<Point>();

        for(int i=1; i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                equalCounter++;
            }
            else{
                countList.add(new Point(s.charAt(i-1),equalCounter));
                equalCounter = 1L;
            }
        }
        countList.add(new Point(s.charAt(s.length()-1), equalCounter));

        for(int i=0; i<countList.size(); i++){
            palindromeCount += (countList.get(i).counter+1)*countList.get(i).counter/2;
        }
        for (int i = 1; i < countList.size()-1; i++) {
            if(countList.get(i).counter == 1
                    && countList.get(i-1).text == countList.get(i+1).text){
                palindromeCount += Math.min(countList.get(i-1).counter,countList.get(i+1).counter);
            }
        }

        return palindromeCount;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
