import java.util.*;

public class CustomLinkedList {
    Node head;
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    void traverse() {
        Node curr = head;
        while(curr!=null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    // Driver code
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEnter no. of elements: ");
        int size = scan.nextInt();
        System.out.print("\nEnter head: ");
        list.head = new Node(scan.nextInt());
        Node curr = list.head;
        for (int i=1; i<size; i++) {
            System.out.print("\nEnter next node: ");
            Node tmp = new Node(scan.nextInt());
            curr.next = tmp;
            curr = tmp;
        }
        scan.close();
        
        // list.head = new Node(1);
        // Node second = new Node(2);
        // list.head.next = second;
        // System.out.println(list.head.data);
        // System.out.println(list.head.next.data);
        list.traverse();
    }
}