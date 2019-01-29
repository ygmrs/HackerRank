import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n ; i++) {
            int value = scanner.nextInt();
            list.add(value);
        }

        int q = scanner.nextInt();
        for (int i = 0; i < q ; i++) {
            String action = scanner.next();
            if(action.equals("Insert")){ // Insert Action
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                list.add(index, value);
            }else{ //Delete action
                int index = scanner.nextInt();
                list.remove(index);
            }
        }

        scanner.close();

        for(Integer num: list){
            System.out.print(num + " ");
        }
    }
}

