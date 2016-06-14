package hackerrank.algortithms.warmup;

import java.util.Scanner;

public class Solution4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String[] b = in.nextLine().split(" ");
        int pos = 0;
        int zero = 0;
        int neg = 0;

        for(String a : b) {
            if(a.startsWith("0")){
                zero++;
            }else{
                if(a.startsWith("-")){
                    neg++;
                }else{
                    pos++;
                }
            }
        }

        double sum = pos + neg + zero;
        System.out.println(pos / sum);
        System.out.println(neg / sum);
        System.out.println(zero / sum);
    }
}