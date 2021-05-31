package BasicPrograms;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of rows for 1st Matrix");
        int m = sc.nextInt();

        System.out.println("Enter no of columns for 1st Matrix");
        int n = sc.nextInt();

        System.out.println("Enter: " + m * n + "elements");

        int a[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j  = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println();
        System.out.println("Entered Matrix 1:");

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(a[i][j] + " ");

                System.out.println();
            }


        System.out.println("Enter no of rows for 2nd Matrix");
        int p = sc.nextInt();

        System.out.println("Enter no of columns for 2nd Matrix");
        int q = sc.nextInt();


        System.out.println("Enter: " + p * q + "elements");

        int b[][] = new int[p][q];

        for (int i = 0; i < p; i++) {
            for (int j  = 0; j < q; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < p; i++) {
            for (int j  = 0; j < q; j++)
                System.out.print(b[i][j] + " ");

            System.out.println();
        }


        if (n != p) {
            System.out.println("Multiplication not possible");
            return;
        }

        int c[][] = new int[m][q];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < q; j++) {
                for (int k  = 0; k < p; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("Multiplication:");

        for (int i = 0; i < m; i++) {
            for (int j  = 0; j < q; j++)
                System.out.print(c[i][j] + " ");

            System.out.println();
        }


    }
}
