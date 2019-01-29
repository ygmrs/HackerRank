import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size ; i++) {
            arr[i] = scanner.nextInt();
        }
        int negativeSubArr = 0;
        for (int j = 0; j < size ; j++) {
            int sum = 0;
            for (int k = j; k < size ; k++) {
                sum += arr[k];
                if(sum<0)
                    negativeSubArr++;
            }
        }
        System.out.println(negativeSubArr);
        scanner.close();
    }
}

