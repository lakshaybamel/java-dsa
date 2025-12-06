package Stack;

import java.util.Stack;

public class UsingJCF {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // push
        stack.push(1);
        stack.push(2);
        stack.push(3);
        // pop + peek
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
