package hackerrank.dynamic;

import java.util.Scanner;

public class StringReduction {

    private static String mut(char l, char r){
        if(l == r){
            return l + "" + r;
        }else{
            if(l == 'a' && r == 'b') return "c";
            if(l == 'a' && r == 'c') return "b";
            if(l == 'b' && r == 'a') return "c";
            if(l == 'b' && r == 'c') return "a";
            if(l == 'c' && r == 'a') return "b";
            if(l == 'c' && r == 'b') return "a";
        }
        return "";
    }

    private static String reduce(String str){
        if(str.length() == 2){
            return mut(str.charAt(0), str.charAt(1));
        }else{
            for(int i = 0 ; i < str.length()-1 ; i++){
                String front = str.substring(0, i);
                String middle = mut(str.charAt(i), str.charAt(i+1));
                String end = str.substring(i+2, str.length());
                String sum = front+middle+end;
                if(!sum.equals(str)){
                    String next = reduce(sum);
                    if(next.length() < str.length()){
                        return next;
                    }
                }
            }
            return str;
        }
    }

    private static int reduce2(String str){
        int[] count = new int[3];
        for(char c : str.toCharArray()){
            count[c - 'a']++;
        }
        if(count[0] == str.length() || count[1] == str.length() || count[2] == str.length()){
            return str.length();
        }else{
            if(count[0] % 2 == 0 && count[1] % 2 == 0 && count[2] % 2 == 0 ||
                    count[0] % 2 == 1 && count[1] % 2 == 1 && count[2] % 2 == 1){
                return 2;
            }else{
                return 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = Integer.parseInt(in.nextLine());
        for(int i = 0 ; i < lines ; i++){
            System.out.println(reduce2(in.nextLine()));
        }
    }
}