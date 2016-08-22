package ctci.strings;

import java.util.Scanner;

public class Ex4 {

    static Scanner in = new Scanner(System.in);

    private static char[] replaceSpaces(char[] s1){
        int insertIndex = s1.length - 1;
        for(int i = s1.length - 1 ; i >= 0 ; i--){
            if(s1[i] != '`'){
                if(s1[i] == ' '){
                    s1[insertIndex] = '0';
                    s1[insertIndex-1] = '2';
                    s1[insertIndex-2] = '%';
                    insertIndex -= 3;
                } else {
                    s1[insertIndex] = s1[i];
                    insertIndex--;
                }
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        String line1 = in.nextLine();
        System.out.println(new String(replaceSpaces(line1.toCharArray())));
    }
}
