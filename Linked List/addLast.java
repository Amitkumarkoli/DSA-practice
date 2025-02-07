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

    public int size(){
        return size;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int removeFirst(){
        if(size==0){
            System.out.println("List is empty");
        }else if(size == 1){
            head = tail = null;
            size = 0;
        }else {
            head = head.next;
            size--;
        }
        return 0;
    }

    public int getFirst(){
        if(size == 0){
            System.out.println("List empty");
            return -1;
        }else {
            return head.data;
        }
    }
    public int getLast(){
        if(size == 0){
            System.out.println("List empty");
            return -1;
        }else {
            return tail.data;
        }
    }
      public int getAt(int idx){   
        if(size == 0){
            System.out.println("List empty");
            return -1;
        }else if(idx < 0 || idx >= size){
            System.out.println("Invalid Argument");
            return -1;
        }else {
            Node temp = head;            
            for(int i = 0; i < idx; i++){
                temp = temp.next;
            }
            return temp.data;
        }
    }

    public void addFirst(int val) {
        Node temp = new Node();
        temp.data = val;
        temp.next = head;
        head = temp;

        if(size == 0){
            tail = temp;
        }
        size++;
    }

    public void addAt(int idx, int val){
        if(idx < 0 || idx > size){
            System.out.println("Invalid arguments");
        }else if(idx == 0){
            addFirst(val);
        }else if(idx == size){
            addLast(val);
        }else {
            Node node = new Node();
            node.data = val;

            Node temp = head;
            for(int i = 0; i < idx-1; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;

            size++;
        }
    }

    public void removeLast(){
         if(size==0){
            System.out.println("List is empty");
        }else if(size == 1){
            head = tail = null;
            size = 0;
        }else {
            Node temp = head;
            for(int i = 0; i < size - 2; i++){
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;
            size--;
        }
    }

    public void removeAt(int idx){
        if(idx < 0 || idx >= size){
            System.out.println("Invalid arguments");
        }else if(idx == 0){
            removeFirst();
        }else if(idx == size - 1){
            removeLast();
        }else {
            Node temp = head;
            for(int i = 0; i < idx - 1; i++ ){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    }
}

public class addLast {  
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
        System.out.println("Linked List size:"+list.size());

        list.removeFirst();

        list.display();

        System.out.println("new Linked List size:"+list.size());

        System.out.println("First element:"+list.getFirst());
        System.out.println("Last element:"+list.getLast());

        System.out.print("Enter index to fetch element: ");
        int index = Integer.parseInt(br.readLine().trim());

        System.out.println("Element at index "+ index + " is: "+list.getAt(index));

        System.out.println("Enter element to add in first: ");
        int firstElement = Integer.parseInt((br.readLine().trim()));
        list.addFirst(firstElement);

        System.out.println("New Linked List: ");
        list.display();

        System.out.println("Enter index to add: ");
        int index = Integer.parseInt(br.readLine().trim());

        System.out.println("Enter element to add at index " + index + ": ");
        int value = Integer.parseInt(br.readLine().trim());

        list.addAt(index, value);

        System.out.println("New Linked List: ");
        list.display();
        System.out.println("Linked List size:"+list.size());


        list.removeLast();
        System.out.println("New Linked List: ");
        list.display();
        System.out.println("Linked List size:"+list.size());



        System.out.print("Enter index to remove: ");
        int removeIndex = Integer.parseInt(br.readLine().trim());

        list.removeAt(removeIndex);

        System.out.println("New Linked List after removing at index " + removeIndex + ":");
        list.display();
        System.out.println("Linked List size: " + list.size());

    }
}
