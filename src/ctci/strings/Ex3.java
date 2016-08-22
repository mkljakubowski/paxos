package ctci.strings;

import java.util.Scanner;

public class Ex3 {

    static Scanner in = new Scanner(System.in);

    private static boolean checkIfPermutation(String s1, String s2){
        if(s1.length() == s2.length()) {
            int[] count = new int[256];
            boolean result = true;
            for (char c : s1.toCharArray()) {
                count[c]++;
            }
            for (char c : s2.toCharArray()) {
                count[c]--;
            }
            for (int c : count) {
                result = result && c == 0;
            }
            return result;
        }
        return false;
    }

    public static void main(String[] args) {
        String line1 = in.nextLine();
        String line2 = in.nextLine();
        System.out.println(checkIfPermutation(line1, line2));
    }
}
