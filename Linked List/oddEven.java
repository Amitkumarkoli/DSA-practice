import java.util.*;

class oddEven {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public oddEven() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public void addLast(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public int getFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        return head.data;
    }

    public void removeFirst() {
        if (size == 0) {
            throw new RuntimeException("List is empty");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }

    public void oddEvenList() {
        oddEven odd = new oddEven();
        oddEven even = new oddEven();

        while (this.size > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (val % 2 == 0) {
                even.addLast(val);
            } else {
                odd.addLast(val);
            }
        }

        if (odd.size > 0 && even.size > 0) {
            odd.tail.next = even.head;
            this.head = odd.head;
            this.tail = even.tail;
            this.size = odd.size + even.size;
        } else if (odd.size > 0) {
            this.head = odd.head;
            this.tail = odd.tail;
            this.size = odd.size;
        } else if (even.size > 0) {
            this.head = even.head;
            this.tail = even.tail;
            this.size = even.size;
        }
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        oddEven list = new oddEven();
        list.addLast(1);
        list.addLast(9);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(7);
        list.addLast(8);

        System.out.println("Original Linked List:");
        list.display();

        list.oddEvenList();

        System.out.println("Linked List after arranging odd and even elements:");
        list.display();
    }
}
