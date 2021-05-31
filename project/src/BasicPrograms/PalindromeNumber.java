package BasicPrograms;

import java.util.Scanner;

public class PalindromeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int n  = sc.nextInt();
        int original = n;

        int rev = 0;
        while (n != 0) {
            rev = (rev * 10) + (n %10);
            n = n / 10;
        }

        if (original != rev) {
            System.out.println("Not a palindrome");
        } else {
            System.out.println("Palindrome");
        }
    }
}
