package Stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int a[] = {5, 1, 3, 2, 10, 6, 12};
        Stack<Integer> stack = new Stack<>();
        for (int i  = 0; i < a.length; i++) {
            if (stack.isEmpty()) {
                stack.push(a[i]);
            } else if (stack.peek() >= a[i]) {
                stack.push(a[i]);
            } else if (stack.peek() < a[i]) {
                System.out.println("Next Greater element of: " + stack.peek() + " is: " + a[i]);
                stack.pop();
                while (!stack.isEmpty()) {
                    if (stack.peek() > a[i])
                        break;

                    if (stack.peek() < a[i]) {
                        System.out.println("Next Greater element of: " + stack.peek() + " is: " + a[i]);
                        stack.pop();
                    }
                }
                stack.push(a[i]);
            }
        }
    }
}
