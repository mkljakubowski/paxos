package ctci.strings;

import java.util.Scanner;

public class Ex7 {

    static Scanner in = new Scanner(System.in);

    private static char[][] clearRowAndColumn(char[][] mat){
        int xs = mat.length;
        int ys = mat[0].length;
        for(int x = 0 ; x < xs ; x++){
            for(int y = 0 ; y < ys ; y++){
                if(mat[x][y] == '0'){
                    for(int i = x ; x >= 0 && mat[i][y] != '0' ; i--){
                        mat[i][y] = '0';
                    }
                    for(int i = y ; y >= 0 && mat[x][i] != '0' ; i--){
                        mat[x][i] = '0';
                    }
                }
                if(x > 0 && mat[x-1][y] == '0' || y > 0 && mat[x][y-1] == '0'){
                    mat[x][y] = '0';
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(in.nextLine());
        char[][] mat = new char[size][];
        for(int i = 0 ; i < size ; i++){
            mat[i] = in.nextLine().toCharArray();
        }
        char[][] res = clearRowAndColumn(mat);
        for(int i = 0 ; i < size ; i++) {
            System.out.println(new String(res[i]));
        }
    }
}
