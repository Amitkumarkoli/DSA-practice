import java.io.*;

class Node {
    int data;
    Node next;
}

class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = null;
        if (size == 0) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class addLast {  // Ensure this matches the filename
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();

        System.out.print("Enter number of elements: ");
        int n = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter elements:");
        String[] elements = br.readLine().trim().split(" ");
        
        for (int i = 0; i < n; i++) {
            list.addLast(Integer.parseInt(elements[i]));
        }

        System.out.println("Linked List:");
        list.display();
    }
}
