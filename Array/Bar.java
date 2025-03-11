import java.util.*;
import java.io.*;

// Bar charts question - a bar charts of astrics rep value of array.

class Bar{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // for length of array

        int[] arr = new int[a];
        for(int i = 0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }

        int max = arr[0];
        for(int i = 1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        for(int floor = max; floor >=1; floor--){
           for(int i = 0; i<arr.length; i++){
           if(arr[i] >= floor){
            System.out.print("*\t");
           }else{
            System.out.print("\t");
           }
        }
        System.out.println();
        }
    }
}