import java.util.*;

public class KthElement {

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

        public void addLast(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }
        
        // kth element from last without using size and use iterative method
        public int kthFromLast(int k) {
            Node s = head;  // Slow pointer
            Node f = head;  // Fast pointer

            for (int i = 0; i < k; i++) {
                if (f == null) {
                    System.out.println("Invalid k value");
                    return -1;
                }
                f = f.next;
            }
 
            while (f != tail) {
                s = s.next;
                f = f.next;
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
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            list.addLast(val);
        }

        list.display();

        System.out.print("Enter k to find kth element from last: ");
        int k = sc.nextInt();
        int result = list.kthFromLast(k);

        if (result != -1) {
            System.out.println("The " + k + "th element from last is: " + result);
        }

        sc.close();
    }
}
