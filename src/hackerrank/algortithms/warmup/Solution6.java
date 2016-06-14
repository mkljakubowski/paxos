package hackerrank.algortithms.warmup;

import java.util.Scanner;

public class Solution6 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] split = line.split(":");
        char noon = split[2].charAt(2);
        int h = Integer.parseInt(split[0]);
        if (noon == 'P' && h != 12) {
            h += 12;
        }
        if (noon == 'A' && h == 12) {
            h += 12;
        }
        h = h % 24;
        String time = h + ":" + split[1] + ":" + split[2].substring(0, 2);
        if (h < 10) {
            time = "0" + time;
        }
        System.out.println(time);
    }
}