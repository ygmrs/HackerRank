import java.io.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(s.getBytes());
            byte[] hash = messageDigest.digest();
            for (byte b: hash) {
                System.out.printf("%02x", b);
            }
        }catch(NoSuchAlgorithmException exp){
            exp.printStackTrace();
        }
    }
}

