package BasicPrograms;

import com.sun.deploy.util.StringUtils;

import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String s = sc.nextLine();
        if (s == null || s.isEmpty()) {
            System.out.println("Pls provide a valid length string");
            return;
        }
        permutation("", s);
    }

    private static void permutation(String prefix, String remaining) {
        if (remaining.length() == 0) {
            System.out.println(prefix);
            return;
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                permutation(prefix + remaining.charAt(i), remaining.substring(0, i) +
                        remaining.substring(i + 1, remaining.length()));
            }
        }
    }
}
