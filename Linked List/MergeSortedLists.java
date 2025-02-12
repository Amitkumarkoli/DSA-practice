class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
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

    //merge two sorted lists
    public static LinkedList mergeTwoSortedLists(LinkedList l1, LinkedList l2) {
        Node one = l1.head;
        Node two = l2.head;

        LinkedList res = new LinkedList();

        while (one != null && two != null) {
            if (one.data < two.data) {
                res.addLast(one.data);
                one = one.next;
            } else {
                res.addLast(two.data);
                two = two.next;
            }
        }

        while (one != null) {
            res.addLast(one.data);
            one = one.next;
        }

        while (two != null) {
            res.addLast(two.data);
            two = two.next;
        }
        return res;
    }

    // To find middle node
    public static Node midNode(Node head, Node tail) {
        Node slow = head;
        Node fast = head;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

   // Merge sort method
    public static LinkedList mergedSort(Node head, Node tail) {
        if (head == tail) {
            LinkedList br = new LinkedList();
            br.addLast(head.data);
            return br;
        }

        Node mid = midNode(head, tail);
        LinkedList fsh = mergedSort(head, mid);
        LinkedList ssh = mergedSort(mid.next, tail);
        LinkedList cl = LinkedList.mergeTwoSortedLists(fsh, ssh);
        return cl;
    }
}

public class MergeSortedLists {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addLast(1);
        list1.addLast(3);
        list1.addLast(5);
        list1.addLast(2);
        list1.addLast(4);
        list1.addLast(6);

        System.out.println("Original List:");
        list1.display();

        LinkedList sortedList = LinkedList.mergedSort(list1.head, list1.tail);
        System.out.println("Sorted List:");
        sortedList.display();
    }
}
