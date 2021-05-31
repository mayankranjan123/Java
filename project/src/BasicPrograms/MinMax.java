package BasicPrograms;

public class MinMax {
    int mid = 0;
    public static void main(String[] args) {
        MinMax minMax = new MinMax();

        int a[] = {4, 2, 1, 6, 5, 3};
        minMax.minAndMax(a, 0, a.length - 1, -1, -1);
    }

    static void minAndMax(int [] a, int lb, int ub, int max, int min) {
        int min1, max1;
        if (lb == ub) {
            min = max = a[lb];
        } else if ((ub - lb) == 1) {
            if (a[lb] > a[ub]) {
                min = a[ub];
                max = a[lb];
            } else {
                min = a[lb];
                max = a[ub];
            }
        } else {
            int mid = (lb + ub) / 2;
            //left sub-array
            minAndMax(a, lb, mid, max, min);
            //right sub-array
            max1 = max;
            min1 = min;
            minAndMax(a, mid + 1, ub, max1, min1);

            if (max1 > max) {
                max = max1;
            }
            if (min1 < min) {
                min = min1;
            }
            System.out.println("Max: " + max + " Min: " + min);
        }
    }
}
