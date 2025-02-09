import java.util.LinkedList;

public class LLToStackAdapter {

    public static class LLStackAdapter {  
        private LinkedList<Integer> list;

        public LLStackAdapter() {
            list = new LinkedList<Integer>(); // Explicit generic type
        }

        public int getSize() { 
            return list.size();
        }

        public void push(int value) { 
            list.addFirst(value);
        }

        public int pop() {
            if (list.isEmpty()) { 
                System.out.println("Stack Underflow");
                return -1;
            }
            return list.removeFirst();
        }

        public int peek() { 
            if (list.isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }
            return list.getFirst();
        }

        public boolean isEmpty() { 
            return list.isEmpty();
        }
    }

    public static void main(String[] args) {
        LLStackAdapter stack = new LLStackAdapter();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); 

        System.out.println("Popped element: " + stack.pop()); 

        System.out.println("Top element after pop: " + stack.peek()); 

        System.out.println("Stack size: " + stack.getSize()); 

        stack.pop();
        stack.pop();

        stack.pop(); // Stack Underflow
    }
}
