// package DataStructures;

// import java.io.*;
// import java.util.*;

public class CustomStack {
    StackNode root;
    static class StackNode {
        int data;
        StackNode next;
        StackNode(int data) {
            this.data = data;
        }
    }

    void push(int val) {
        StackNode newNode = new StackNode(val);
        if (root == null) root = newNode;
        else {
            StackNode tmp = root;
            root = newNode;
            newNode.next = tmp;
        }
        System.out.println("Pushed " + val);
    }

    void pop() {
        if (root == null) System.out.println("Stack empty!");
        else {
            int val = root.data;
            root = root.next;
            System.out.println("Popped " + val);
        }
    }

    int peek() {
        if (root == null) return Integer.MIN_VALUE;
        return root.data;
    }

    boolean isEmpty() {
        if (root == null) return true;
        return false;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        CustomStack stack = new CustomStack();
        for (int a: arr) stack.push(a);
        stack.pop();
    }
    
}