package hackerrank.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Insertion1 {

    private static void printT(int[] c){
        for(int i=0;i<c.length;i++){
            System.out.print(c[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String[] b = in.nextLine().split(" ");
        int[] c = new int[b.length];
        int i;

        for(i=0;i<b.length;i++){
            c[i] = Integer.parseInt(b[i]);
        }
        int elem = c[b.length - 1];
        for(i = b.length - 1 ; i > 0 ; i--) {
            if(c[i-1] <= elem){
                break;
            }
            c[i] = c[i-1];
            printT(c);
        }
        c[i] = elem;
        printT(c);
    }
}