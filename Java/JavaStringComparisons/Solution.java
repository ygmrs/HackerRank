import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        java.util.TreeSet<String> wordSet = new java.util.TreeSet<String>();
        int end = k;
        for(int i=0; i<s.length(); i++){
            wordSet.add(s.substring(i, end));
            if((end += 1) > s.length()) break;
        }
        smallest = wordSet.first();
        largest = wordSet.last();
        return smallest + "\n" + largest;
    }
}

