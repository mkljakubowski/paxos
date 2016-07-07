package hackerrank.search;

import java.util.Arrays;
import java.util.Scanner;

public class MissingNumbers {

    static void doStuff(int[] numbers1, int[] numbers2){
        Arrays.sort(numbers1);
        Arrays.sort(numbers2);
        int[] result = new int[100];
        int i = 0;

        for(i = 0 ; i < numbers2.length ; i++){
            if(numbers1[i] != numbers2[i]){
                break;
            }
        }
        int firstMissing = numbers2[i];
        while (true){
            if(i < numbers1.length && numbers1[i] >= firstMissing && numbers1[i] < firstMissing + 100){
                result[numbers1[i] - firstMissing]++;
            }
            if(i < numbers2.length && numbers2[i] >= firstMissing && numbers2[i] < firstMissing + 100){
                result[numbers2[i] - firstMissing]--;
            }
            if((i >= numbers1.length || numbers1[i] > firstMissing + 100) && (i >= numbers2.length || numbers2[i] > firstMissing + 100)){
                break;
            }
            i++;
        }

        for (i = 0 ; i < 100 ; i++){
            if(result[i]!=0){
                System.out.print((i+firstMissing) + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int count1 = Integer.parseInt(in.nextLine());
        int[] numbers1 = new int[count1];
        String[] line1 = in.nextLine().split(" ");
        for(int i = 0 ; i < count1 ; i++){
            numbers1[i] = Integer.parseInt(line1[i]);
        }
        int count2 = Integer.parseInt(in.nextLine());
        int[] numbers2 = new int[count2];
        String[] line2 = in.nextLine().split(" ");
        for(int i = 0 ; i < count2 ; i++){
            numbers2[i] = Integer.parseInt(line2[i]);
        }
        doStuff(numbers1, numbers2);
    }
}
