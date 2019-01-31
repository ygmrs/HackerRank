import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(x/y);
            scanner.close();
        }catch (InputMismatchException exp){
            System.out.println("java.util.InputMismatchException");
        }catch (ArithmeticException exp){
            System.out.println("java.lang.ArithmeticException: / by zero");
        }
    }
}

