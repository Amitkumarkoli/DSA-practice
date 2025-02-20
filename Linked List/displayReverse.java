import java.util.*;

class displayReverse {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

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

    public void addFirst(int val) {
        Node newNode = new Node(val);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
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

    public void displayReverse(int k) {
        displayReverse prev = null;

        while (this.size > 0) {
            displayReverse curr = new displayReverse();

            if (this.size >= k) {
                for (int i = 0; i < k; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addFirst(val); 
                }
            } else {
                int os = this.size();
                for (int i = 0; i < os; i++) {
                    int val = this.getFirst();
                    this.removeFirst();
                    curr.addLast(val);
                }
            }

            if (prev == null) {
                prev = curr;
            } else {
                prev.tail.next = curr.head;
                prev.tail = curr.tail;
                prev.size += curr.size;
            }
        }
        this.head = prev.head;
        this.tail = prev.tail;
        this.size = prev.size;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Display reverse Linked List recursively method
    
    private void displayReverseHelper(Node node){
        if(node == null){
            return;
        }displayReverseHelper(node.next);
        System.out.print(node.data + " ");
    }

    public void displayReverse(){
        displayReverseHelper(head);
        System.out.println();
    }

    public static void main(String[] args) {
        displayReverse list = new displayReverse();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);

        System.out.println("Original Linked List:");
        list.display();

        System.out.println("Linked List after reversing recursively: ");
        list.displayReverse();
    }
}
