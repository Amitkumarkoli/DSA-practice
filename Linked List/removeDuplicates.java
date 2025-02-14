// public void removeDuplicates(){
//     LinkedList res = new LinkedList();

//     while(this.size() > 0){
//         int val = this.getFirst();
//         this.removeFirst();

//         if(res.size() == 0 || res.tail.data != val){
//             res.addLast(val);
//         }
//     }

//     this.head = res.head;
//     this.tail = res.tail;
//     this.size = res.size;
// }

























































import java.util.*;

class removeDuplicates {  // Updated class name to match file name
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

    public removeDuplicates() {  // Updated constructor to match class name
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

    public void removeDuplicates() {
        removeDuplicates res = new removeDuplicates(); // Updated to match new class name

        while (this.size() > 0) {
            int val = this.getFirst();
            this.removeFirst();

            if (res.size() == 0 || res.tail.data != val) {
                res.addLast(val);
            }
        }

        this.head = res.head;
        this.tail = res.tail;
        this.size = res.size;
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
        removeDuplicates list = new removeDuplicates(); // Updated object instantiation
        list.addLast(1);
        list.addLast(1);
        list.addLast(2);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(4);

        System.out.println("Before removing duplicates:");
        list.display();

        list.removeDuplicates();

        System.out.println("After removing duplicates:");
        list.display();
    }
}
