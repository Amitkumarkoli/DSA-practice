import java.io.*;

class NormalQueue {

    public static class CustomQueue {
        int[] data;
        int front;
        int size;

        public CustomQueue(int cap) {
            data = new int[cap];
            front = 0;
            size = 0;
        }

        int size() {
            return size;
        }

        void display() {
            for (int i = 0; i < size; i++) {
                int idx = (front + i) % data.length;
                System.out.print(data[idx] + " ");
            }
            System.out.println();
        }

        void add(int val) {
            if (size == data.length) {
                System.out.println("Queue Overflow");
            } else {
                int rear = (front + size) % data.length;
                data[rear] = val;
                size++;
            }
        }

        int remove() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                int val = data[front];
                front = (front + 1) % data.length;
                size--;
                return val;
            }
        }

        int peek() {
            if (size == 0) {
                System.out.println("Queue Underflow");
                return -1;
            } else {
                return data[front];
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter queue capacity: ");
        int capacity = Integer.parseInt(br.readLine().trim());

        CustomQueue queue = new CustomQueue(capacity);

        while (true) {
            String command = br.readLine().trim();

            if (command.startsWith("add")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                queue.add(val);
            } else if (command.equals("remove")) {
                int result = queue.remove();
                if (result != -1) {
                    System.out.println("Removed: " + result);
                }
            } else if (command.equals("peek")) {
                int result = queue.peek();
                if (result != -1) {
                    System.out.println("Front: " + result);
                }
            } else if (command.equals("size")) {
                System.out.println("Size: " + queue.size());
            } else if (command.equals("display")) {
                queue.display();
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Use: add <value>, remove, peek, size, display, exit");
            }
        }
    }
}
