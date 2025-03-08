import java.util.*;

class StackToQueueAdapter {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAdapter() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    int size() {
        return mainS.size(); 
    }

    void add(int val){
        while(mainS.size() > 0){
            helperS.push(mainS.pop());
        }
        
        mainS.push(val);

        while(helperS.size() > 0){
            mainS.push(helperS.pop());
        }
    }

    int remove() {
        if(size() == 0){
            System.out.println("Queue Underflow");
            return -1;
        }else {
            return mainS.pop();
        }
    }

    int peek() {
        if(size() == 0){
            System.out.println("Queue Underflow");
            return -1;
        }else {
            return mainS.peek();
        }
    }

    public static void main(String[] args) {
        StackToQueueAdapter queue = new StackToQueueAdapter();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println("Front element: " + queue.peek()); // Output: 10
        System.out.println("Removed element: " + queue.remove()); // Output: 10
        System.out.println("Removed element: " + queue.remove()); // Output: 20
        System.out.println("Queue size: " + queue.size()); // Output: 2
    }
}
