import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length())
            return false;
        a = a.toUpperCase();
        b = b.toUpperCase();

        for(char alphabet='A'; alphabet<='Z'; alphabet++){
            char finalAlphabet = alphabet;
            long count = a.chars().filter(ch -> ch == finalAlphabet).count();
            long count2 = b.chars().filter(ch -> ch == finalAlphabet).count();
            if (count != count2)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
