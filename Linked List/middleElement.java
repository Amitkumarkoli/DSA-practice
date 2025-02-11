import java.util.*;

public class middleElement {

    public static class LinkedList {
        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        private Node head;
        private Node tail;

        public void insert(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        public int mid() {
            Node s = head;
            Node f = head;

            while (f.next != null && f.next.next != null) {
                s = s.next;
                f = f.next.next;
            }

            return s.data;
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");
        if (n > 0) {
            list.head = new LinkedList.Node(sc.nextInt());
            LinkedList.Node temp = list.head;

            for (int i = 1; i < n; i++) {
                temp.next = new LinkedList.Node(sc.nextInt());
                temp = temp.next;
            }
            list.tail = temp;
        }

        list.display();

        System.out.println("Middle element is: " + list.mid());

        sc.close();
    }
}
