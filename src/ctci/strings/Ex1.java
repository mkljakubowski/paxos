package ctci.strings;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

    static Scanner in = new Scanner(System.in);

    private static boolean findDuplicates2(char[] arr){
        Arrays.sort(arr);

        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(arr[i] == arr[i+1]){
                return true;
            }
        }

        return false;
    }

    private static boolean findDuplicates1(char[] arr){
        int[] count = new int[256];
        boolean result = false;
        for(char c : arr){
            count[c]++;
        }
        for(int c : count){
            result = result || c > 1;
        }
        return result;
    }

    public static void main(String[] args) {
        String line = in.nextLine();
        System.out.println(findDuplicates2(line.toCharArray()));
    }
}
