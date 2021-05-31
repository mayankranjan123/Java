package BasicPrograms;

import java.util.Scanner;

public class PowerFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 2 digits");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("Power: " + pow(x, y));
    }

    private static int pow(int x, int y) {
        if (y == 0)
            return 1;
        else if (y == 1)
            return x;
        else if (y % 2 == 0)
            return pow(x, y / 2) * pow(x, y / 2);
        else
            return x * pow(x, y / 2) * pow(x, y / 2);
    }
}
