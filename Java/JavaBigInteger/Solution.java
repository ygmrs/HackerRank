import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger a =  new BigInteger(scanner.next());
        BigInteger b =  new BigInteger(scanner.next());
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
        scanner.close();
    }
}

