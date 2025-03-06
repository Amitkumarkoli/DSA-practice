import java.util.*;

class StackToQueueAddEfficient {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAddEfficient() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    int size() {
        return mainS.size(); 
    }

    void add(int val){
        mainS.push(val);
    }

    int remove() {
        if(size() == 0){
            System.out.println("Queue Underflow");
            return -1;
        }else {
            while(mainS.size() > 1){
                helperS.push(mainS.pop());
            }

            int val = mainS.pop();

            while(helperS.size() > 0){
                mainS.push(helperS.pop());
            }

            return val;
        }
    }

    int peek() {
        if(size() == 0){
            System.out.println("Queue Underflow");
            return -1;
        }else {
            while(mainS.size() > 1){
                helperS.push(mainS.pop());
            }

            int val = mainS.pop();
            helperS.push(val);

            while(helperS.size() > 0){
                mainS.push(helperS.pop());
            }

            return val;
        }
    }

    public static void main(String[] args) {
        StackToQueueAddEfficient queue = new StackToQueueAddEfficient();

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
