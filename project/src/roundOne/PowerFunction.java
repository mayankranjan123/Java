package roundOne;

import java.util.Scanner;

public class PowerFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("Power: " + power(x, y));
    }

    private static int power(int x, int y) {
        if (x == 0)
            return 0;
        else if (y == 0)
            return 1;
        else if (y % 2 == 0) {
            int res = power(x, y / 2) * power(x, y / 2);
            return res;
        } else {
            return x * power(x, y / 2) * power(x, y / 2);
        }

    }
}
