import java.util.*;
import java.io.*;

public class NGE_right{
    public static void display(int[] a){
        StringBuilder sb = new StringBuilder();

        for(int val: a){
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] a = new int[n];
    for(int i = 0; i<n; i++){
        a[i] = Integer.parseInt(br.readLine());
    }

    int[] nge = solve(a);
    display(nge);
}

public static int[] solve(int[] arr){

    int[] nge = new int[arr.length];  // Result array for NGEs.
    Stack<Integer> st = new Stack<>();  // Stack to track potential greater elements.


    st.push(arr[arr.length - 1]);  // Push the last element to the stack.
    nge[arr.length - 1] = -1;  // Last element has no greater element to its right.

    for (int i = arr.length - 2; i >= 0; i--) {  
    // Traverse the array from right to left.
      while (st.size() > 0 && arr[i] >= st.peek()) {
        st.pop();  // Remove elements from stack that are smaller than or equal to `arr[i]`.
    }

    if (st.size() == 0) {
        nge[i] = -1;  // No greater element to the right.
    } else {
        nge[i] = st.peek();  // Top of stack is the NGE.
    }

    st.push(arr[i]);  // Push the current element into the stack.
}

    return nge;
}
}