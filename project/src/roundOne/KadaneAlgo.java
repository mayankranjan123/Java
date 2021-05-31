package roundOne;

public class KadaneAlgo {
    public static void main(String[] args) {
       int a [] = new int[] {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum Sum: " + maxSum(a, a.length));
        maxSumSubArray(a, a.length);
    }

    private static void maxSumSubArray(int[] a, int n) {
        int maxEndHere = 0, maxSoFar = a[0], start = 0, end = 0, s = 0;

        for (int i = 0; i < n; i++) {
            maxEndHere += a[i];
            if (maxEndHere > maxSoFar) {
                start = s;
                end = i;
                maxSoFar = maxEndHere;
            }

            if (maxEndHere < 0) {
                s = i + 1;
                maxEndHere = 0;
            }
        }

        System.out.println("Start: " + start + ", and end: " + end);
    }

    private static int maxSum(int[] a, int n) {
        int maxEndHere = 0, maxSoFar = a[0];

        for (int i = 0; i < n; i++) {
            maxEndHere += a[i];
            if (maxEndHere > maxSoFar) {
                maxSoFar = maxEndHere;
            }

            if (maxEndHere < 0) {
                maxEndHere = 0;
            }
        }
        return maxSoFar;

    }
}
