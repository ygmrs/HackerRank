import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            BitSet b1 = new BitSet(sc.nextInt());
            BitSet b2 = new BitSet(sc.nextInt());
            sc.nextLine();

            while (sc.hasNext()) {

                String operation = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();

                if (operation.equals("AND")) {
                    if (x == 1) {
                        b1.and(b2);
                    } else {
                        b2.and(b1);
                    }
                } else if (operation.equals("OR")) {
                    if (x == 1) {
                        b1.or(b2);
                    } else {
                        b2.or(b1);
                    }
                } else if (operation.equals("XOR")) {
                    if (x == 1) {
                        b1.xor(b2);
                    } else {
                        b2.xor(b1);
                    }
                } else if (operation.equals("FLIP")) {
                    if (x == 1) {
                        b1.flip(y);
                    } else {
                        b2.flip(y);
                    }
                } else if (operation.equals("SET")) {
                    if (x == 1) {
                        b1.set(y);
                    } else {
                        b2.set(y);
                    }
                }
                System.out.print(b1.cardinality());
                System.out.print(" ");
                System.out.println(b2.cardinality());
            }
        }
    }
}

