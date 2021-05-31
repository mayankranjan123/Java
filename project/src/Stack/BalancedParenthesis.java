package Stack;

import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        System.out.println("Enter a String");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Is Balanced Parenthesis: " + isBalanced(stack, s));
    }

    private static boolean isBalanced(java.util.Stack<Character> stack, String s) {
        if (s == null || s.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
                } else if (stack.isEmpty()) {
                    return false;
                } else if (s.charAt(i) == ')' && stack.peek() == '(') {
                    stack.pop();
                }  else if (s.charAt(i) == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (s.charAt(i) == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if (stack.isEmpty())
                return true;
            return false;
        }

    }
}
