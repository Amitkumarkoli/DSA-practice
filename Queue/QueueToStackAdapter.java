import java.util.*;

class QueueToStackAdapter {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapter() {
        mainQ = new LinkedList<>();
        helperQ = new LinkedList<>();
    }

    int size() {
        return mainQ.size(); 
    }

    void push(int val) {
        while (!mainQ.isEmpty()) {
            helperQ.add(mainQ.remove());
        }

        mainQ.add(val);

        while (!helperQ.isEmpty()) {
            mainQ.add(helperQ.remove());
        }
    }

    int pop() {
        if (mainQ.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return mainQ.remove();
        }
    }

    int top() {
        if (mainQ.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        } else {
            return mainQ.peek();
        }
    }

    public static void main(String[] args) {
        QueueToStackAdapter stack = new QueueToStackAdapter();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top()); 
        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Stack size: " + stack.size()); 
    }
}
