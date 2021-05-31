package BasicPrograms;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size");
        int n = sc.nextInt();
        int[] a = new int[n];

        System.out.println("Enter: " + n + " digits");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.println("GCD :" + gcd(a[0], a[1]));
        System.out.println("LCM :" + (a[0] * a[1]) / gcd(a[0], a[1]));
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        else if (b == 0)
            return a;
        else if (a == b)
            return a;
        else if (a > b)
            return gcd(a - b, b);
        else
            return gcd(a, b - a);
    }
}
