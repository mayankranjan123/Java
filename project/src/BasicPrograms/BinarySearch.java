package BasicPrograms;

import java.util.Scanner;

public class BinarySearch {
    static int mid = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Enter element to find");
        int item = sc.nextInt();

        System.out.println("Element present at: " + binary(a, 0, n - 1, item));
    }

    private static int binary(int[] a, int lb, int ub, int item) {
        if (lb <= ub) {
            mid = (lb + ub) / 2;
            if (a[mid] > item) {
                return binary(a, lb, mid - 1, item);
            } else if (a[mid] < item) {
                return binary(a, mid + 1, ub, item);
            } else if (a[mid] == item){
                return mid;
            }
        }
        return -1;
    }
}
