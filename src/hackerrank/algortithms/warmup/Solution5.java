package hackerrank.algortithms.warmup;

import java.util.Scanner;

public class Solution5 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine());

        for(int i = 0 ; i < size ; i++) {
            char[] arr = new char[size];
            for(int j = 0 ; j < size ; j++){
                if(i>j-1){
                    arr[size-j-1]='#';
                }else{
                    arr[size-j-1]=' ';
                }
            }
            System.out.println(new String(arr));
        }
    }
}