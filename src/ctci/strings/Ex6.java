package ctci.strings;

import java.util.Scanner;

public class Ex6 {

    static Scanner in = new Scanner(System.in);

    private static String[][] rotateLeft(String[][] mat){
        int s = mat.length;
        for(int layer = 0 ; layer < s / 2 ; layer++){
            for(int x = layer ; x < s - layer - 1 ; x++){
                String buf = mat[layer][x];
                mat[layer][x] = mat[x][s-layer-1];
                mat[x][s-layer-1] = mat[s-layer-1][s-x-1];
                mat[s-layer-1][s-x-1] = mat[s-x-1][layer];
                mat[s-x-1][layer] = buf;
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(in.nextLine());
        String[][] mat = new String[size][];
        for(int i = 0 ; i < size ; i++){
            mat[i] = in.nextLine().split(" ");
        }
        String[][] res = rotateLeft(mat);
        for(int i = 0 ; i < size ; i++) {
            System.out.println(String.join(" ", res[i]));
        }
    }
}
