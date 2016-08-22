package ctci.strings;

import java.util.Scanner;

public class Ex5 {

    static Scanner in = new Scanner(System.in);

    private static String compress(String s){
        int[] count = new int[256];
        for(char c : s.toCharArray()){
            count[c]++;
        }
        StringBuilder bob = new StringBuilder();

        for(int i = 0 ; i < 256 ; i++){
            if(count[i]>0){
                bob.append((char)i).append(count[i]);
            }
        }

        if(bob.length() > s.length()){
            return s;
        } else {
            return bob.toString();
        }
    }

    public static void main(String[] args) {
        String line1 = in.nextLine();
        System.out.println(compress(line1));
    }
}
