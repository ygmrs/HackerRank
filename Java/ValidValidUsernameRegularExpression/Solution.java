import java.util.Scanner;

class UsernameValidator {
    public static final String regularExpression = "([a-zA-Z])(\\w){7,29}";
}

/*Char| Dec | Hex
        ---------------
        A  | 65  | 41
        B  | 66  | 42
        ... |     |
        Y  | 89  | 59
        Z  | 90  | 5A
        [  | 91  | 5B // Bracket
        \  | 92  | 5C // Backslash
        ]  | 93  | 5D // Bracket
        ^  | 94  | 5E // Caret
        _  | 95  | 5F // Underscore
        `  | 96  | 60 // Backtick
        a  | 97  | 61
        b  | 98  | 62
        ... |     |
        y  | 121 | 79
        z  | 122 | 7A*/

public class Solution {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}