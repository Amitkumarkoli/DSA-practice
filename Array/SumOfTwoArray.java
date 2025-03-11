import java.util.*;

class SumOfTwoArray {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // Input first array
        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();
        int[] a1 = new int[n1];
        System.out.println("Enter elements of first array:");
        for (int i = 0; i < n1; i++) {
            a1[i] = sc.nextInt();
        }

        // Input second array
        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();
        int[] a2 = new int[n2];
        System.out.println("Enter elements of second array:");
        for (int i = 0; i < n2; i++) {
            a2[i] = sc.nextInt();
        }

        int[] sum = new int[Math.max(n1, n2)];
        int c = 0;

        int i = a1.length - 1;
        int j = a2.length - 1;
        int k = sum.length - 1;

        while (k >= 0) {
            int d = c;
            if (i >= 0) {
                d += a1[i];
                i--;
            }
            if (j >= 0) {
                d += a2[j];
                j--;
            }

            c = d / 10;
            d = d % 10;

            sum[k] = d;
            k--;
        }

        if (c != 0) {
            System.out.print(c + " ");
        }
        for (int val : sum) {
            System.out.print(val + " ");
        }

        sc.close();
    }
}
