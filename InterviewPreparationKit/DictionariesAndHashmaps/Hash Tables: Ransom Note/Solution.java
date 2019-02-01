import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static int sherlockAndAnagrams(String s) {
        int n = s.length();
        int I = 1;
        int numOfAnagrams = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j <= n-I; j++) {
                String s1 = s.substring(j, j + I);
                for(int k = j+1; k <= n-I; k++) {
                    String s2 = s.substring(k, k + I);
                    if(checkAnagrams(s1, s2))
                        numOfAnagrams++;
                }
            }
            I++;
        }
        return numOfAnagrams;
    }

    static boolean checkAnagrams(String s1, String s2) {
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();
        
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        for(int i = 0; i < s1.length(); i++) {
            Character s1Char = Character.valueOf(s1Chars[i]);
            Character s2Char = Character.valueOf(s2Chars[i]);

            if(s1Map.containsKey(s1Char))
                s1Map.put(s1Char, s1Map.get(s1Char) + 1);
            else
                s1Map.put(s1Char, 1);
            
            if(s2Map.containsKey(s2Char))
                s2Map.put(s2Char, s2Map.get(s2Char) + 1);
            else
                s2Map.put(s2Char, 1);
        }

        return s1Map.equals(s2Map);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

