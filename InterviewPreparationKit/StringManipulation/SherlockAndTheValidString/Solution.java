import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        int removed_char = 0;
        String result = "YES";
        for(char letter: s.toCharArray()){
            if(frequencies.containsKey(letter)){
                frequencies.put(letter, frequencies.get(letter)+1);
            }else{
                frequencies.put(letter, 1);
            }
        }
        int currentValue = 0;
        for(Map.Entry<Character, Integer> entry: frequencies.entrySet()){
            if(currentValue == 0){
                currentValue = entry.getValue();
            }else{
                int diff = Math.abs(currentValue - entry.getValue());
                if(entry.getValue() > 1 && diff > 0){
                    removed_char += diff;
                }else if(entry.getValue() == 1 && diff > 0){
                    removed_char++;
                }
            }
        }
        if(removed_char > 1){
            result = "NO";
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
