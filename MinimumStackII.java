import java.io.*;
import java.util.*;

class MinimumStackII {
    public static class MinStack {
        Stack<Integer> data;
        int min;

        public MinStack() {
            data = new Stack<>();
        }

        int size() {
            return data.size();
        }

        void push(int val) {
            if (data.size() == 0) {
                data.push(val);
                min = val;
            } else if (val < min) {  // Store encoded value when pushing a new minimum
                data.push(2 * val - min);
                min = val;
            } else {
                data.push(val);
            }
        }

        int pop() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                int val = data.pop();
                if (val < min) {  // Decoding logic for min
                    int oldMin = min;
                    min = 2 * min - val;
                    return oldMin;
                }
                return val;
            }
        }

        int top() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                if (data.peek() < min) {
                    return min;
                } else {
                    return data.peek();
                }
            }
        }

        int min() {
            if (size() == 0) {
                System.out.println("Stack underflow");
                return -1;
            } else {
                return min;  // Fixing the recursive error
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MinimumStackII.MinStack stack = new MinimumStackII.MinStack();

        while (true) {
            String command = br.readLine().trim();

            if (command.startsWith("push")) {
                int val = Integer.parseInt(command.split(" ")[1]);
                stack.push(val);
            } else if (command.equals("pop")) {
                int result = stack.pop();
                if (result != -1) {
                    System.out.println("Popped: " + result);
                }
            } else if (command.equals("top")) {
                int result = stack.top();
                if (result != -1) {
                    System.out.println("Top: " + result);
                }
            } else if (command.equals("min")) {
                int result = stack.min();
                if (result != -1) {
                    System.out.println("Min: " + result);
                }
            } else if (command.equals("size")) {
                System.out.println("Size: " + stack.size());
            } else if (command.equals("exit")) {
                break;
            } else {
                System.out.println("Invalid command. Please use one of the following:");
                System.out.println("push <value>, pop, top, min, size, exit");
            }
        }
    }
}
