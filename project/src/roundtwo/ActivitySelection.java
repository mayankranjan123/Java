package roundtwo;

public class ActivitySelection {

    // driver program to test above function
    public static void main(String[] args) {
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 6, 7, 9, 9};
        int n = s.length;
        printMaxActivities(s, f, n);
    }

    static void printMaxActivities(int s[], int f[], int n) {
        int i, j;

        System.out.println("Following activities are selected n");

        // The first activity always gets selected
        i = 0;
        System.out.println(i);

        // Consider rest of the activities
        for (j = 1; j < n; j++) {
            // If this activity has start time greater than or
            // equal to the finish time of previously selected
            // activity, then select it
            if (s[j] >= f[i]) {
                System.out.println(j);
                i = j;
            }
        }
    }
}
