// package DataStructures;

// import java.io.*;
// import java.util.*;

public class CustomQueue {
    QNode front, rear;
    static class QNode {
        QNode next;
        int data;
        QNode(int data) {
            this.data = data;
        }
    }

    void enqueue(int data) {
        QNode newNode = new QNode(data);
        if(rear == null) front = rear = newNode;
        else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Enqueued " + data);
    }

    void dequeue() {
        if(front == null) System.out.println("Queue Empty!");
        else {
            QNode tmp = front;
            front = front.next;
            System.out.println("Dequeued " + tmp.data);
        }
    }

    int front() {
        return front.data;
    }

    int rear() {
        return rear.data;
    }

    // Driver code
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        CustomQueue queue = new CustomQueue();
        for (int a: arr) queue.enqueue(a);
        queue.dequeue();
    }
}