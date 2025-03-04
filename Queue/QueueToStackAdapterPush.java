import java.util.*;

class QueueToStackAdapterPush {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackAdapterPush() {
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
        if(size() == 0){
            System.out.println("Stack Underflow");
            return -1;
        }else {
            while(mainQ.size() > 1){
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();

            while(helperQ.size() > 0){
                mainQ.add(helperQ.remove());
            }
            return val;
        }
    }

    int top() {
        if(size() == 0){
            System.out.println("Stack Underflow");
            return -1;
        }else {
            while(mainQ.size() > 1){
                helperQ.add(mainQ.remove());
            }
            int val = mainQ.remove();
            helperQ.add(val);

            while(helperQ.size() > 0){
                mainQ.add(helperQ.remove());
            }
            return val;
        }
    }

    public static void main(String[] args) {
        QueueToStackAdapterPush stack = new QueueToStackAdapterPush();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top()); 
        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Popped element: " + stack.pop()); 
        System.out.println("Stack size: " + stack.size()); 
    }
}
