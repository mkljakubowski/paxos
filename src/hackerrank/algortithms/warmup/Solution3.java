package hackerrank.algortithms.warmup;

import java.io.*;
        import java.math.BigDecimal;
        import java.util.*;

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int lines = Integer.parseInt(in.nextLine());
        int d1 = 0;
        int d2 = 0;

        for(int i = 0 ; i < lines ; i++) {
            String[] b = in.nextLine().split(" ");
            d1 += Integer.parseInt(b[i]);
            d2 += Integer.parseInt(b[lines - i - 1]);
        }

        System.out.println(Math.abs(d1-d2));
    }
}