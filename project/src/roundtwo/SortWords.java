package roundtwo;

import java.util.Arrays;

public class SortWords {
    public static void main(String[] args) {
        String[] words= new String[] {"abc", "xy", "bcd"};
        for (String word: words)
            System.out.print(word + " ");

        System.out.println("After Sorting");
        Arrays.sort(words);

        for (String word: words)
            System.out.print(word + " ");

    }
}
