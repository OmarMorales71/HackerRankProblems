package omar.problems.stacksAndQueues;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ATaleOfTwoStacks {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

class MyQueue<T> {

    private Stack<T> stack;
    private Stack<T> placeHolder;

    public MyQueue() {
        stack = new Stack<T>();
        placeHolder = new Stack<T>();
    }

    public void enqueue(T element) {
        stack.push(element);
    }

    public T dequeue() {
        T ans = null;
        if (placeHolder.empty()) {
            while (stack.size() > 1) {
                placeHolder.push(stack.pop());
            }
            ans = stack.pop();
        }else{
            ans = placeHolder.pop();
        }
        return ans;
    }

    public T peek() {
        T ans = null;
        if (placeHolder.empty()) {
            while (stack.size() > 1) {
                placeHolder.push(stack.pop());
            }
            ans = stack.pop();
            placeHolder.push(ans);
        }else{
            ans = placeHolder.peek();
        }
        return ans;
    }
}

