import java.util.*;
import java.io.*;

class MinimumStack {
    public static class MinStack {
       Stack<Integer> allData;
       Stack<Integer> minData;

        public MinStack() {
            allData = new Stack<>();
            minData = new Stack<>();
        }

        int size() {
            return allData.size();
        }

        void push(int val) {
           allData.push(val);

           if(minData.size() == 0 || val <= minData.peek()){
            minData.push(val);
           }
        }

        int pop() {
           if(size() == 0 ){
            System.out.println("Stack underflow");
            return -1;
            }else {
                int val = allData.pop();

                if(val == minData.peek()){
                    minData.pop();
                }
                return val;
            }
        }

        int top() {
           if(size() == 0 ){
            System.out.println("Stack underflow");
            return -1;
            }else {
                return allData.peek();
            }
        }

        int min(){
            if(size() == 0 ){
            System.out.println("Stack underflow");
            return -1;
            }else {
                return allData.peek();
            }
        }
    }

   public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        NormalStack.MinStack stack = new NormalStack.MinStack();

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
