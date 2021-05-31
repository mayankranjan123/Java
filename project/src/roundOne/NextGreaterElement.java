package roundOne;

import java.util.Stack;

public class NextGreaterElement {
    Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        int a[] = new int[]{4, 5, 2, 25};
        NextGreaterElement element = new NextGreaterElement();
        element.nextGreaterElement(a, a.length);
    }

    private void nextGreaterElement(int[] a, int n) {
        if (a == null || n <= 0)
            return;
        else {
            for (int i = 0; i < n; i++) {
                if (stack.isEmpty()) {
                    stack.push(a[i]);
                } else {
                    if (stack.peek() > a[i]) {
                        stack.push(a[i]);
                    } else {
                        while (!stack.isEmpty()) {
                            if (stack.peek() > a[i]) {
                                stack.push(a[i]);
                            } else {
                                Integer element = stack.pop();
                                System.out.println(element);
                            }
                        }
                    }
                }
            }


        }

    }
}
