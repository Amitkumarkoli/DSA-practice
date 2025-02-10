import java.util.LinkedList;

public class LLToQueueAdapter {

    public static class LLQueueAdapter {  
        private LinkedList<Integer> list;

        public LLQueueAdapter() {
            list = new LinkedList<Integer>(); // Explicit generic type
        }

        public int Size() { 
            return list.size();
        }

        public void add(int val) { 
            list.addLast(val);
        }

        public int remove() {
            if (list.size() == 0) { 
                System.out.println("Queue Underflow");
                return -1;
            }else{
                return list.removeFirst();
            }
        }

        public int peek() { 
            if (list.size() == 0) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return list.getFirst();
        }

    }

    public static void main(String[] args) {
        LLQueueAdapter Queue = new LLQueueAdapter();

        Queue.add(10);
        Queue.add(20);
        Queue.add(30);

        System.out.println("Top element: " + Queue.peek()); 

        System.out.println("Popped element: " + Queue.remove()); 

        System.out.println("Top element after remove: " + Queue.peek()); 

        System.out.println("Queue size: " + Queue.list.size()); 

        Queue.remove();
        Queue.remove();

        Queue.remove(); // Queue Underflow
    }
}
