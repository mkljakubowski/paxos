package hackerrank.greedy;

import java.util.Scanner;

public class Grid {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = Integer.parseInt(in.nextLine());

        for(int problem = 0 ; problem < lines ; problem++){
            int size = Integer.parseInt(in.nextLine());
            char prevLineMin = 'a';
            char prevLineMax = 'a';
            boolean canBeSorted = true;

            for(int line = 0 ; line < size ; line++){
                String chars = in.nextLine();
                char curLineMin = 'z';
                char curLineMax = 'a';
                for(char c : chars.toCharArray()){
                    if(c < curLineMin) curLineMin = c;
                    if(c > curLineMax) curLineMax = c;
                }
                if(canBeSorted){
                    if(curLineMin < prevLineMin || curLineMax < prevLineMax){
                        canBeSorted = false;
                    }
                }
                prevLineMax = curLineMax;
                prevLineMin = curLineMin;
            }
            String result = canBeSorted ? "YES" : "NO";
            System.out.println(result);
        }
    }
}
