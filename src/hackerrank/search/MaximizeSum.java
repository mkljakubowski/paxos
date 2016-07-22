package hackerrank.search;

import java.util.Arrays;
import java.util.Scanner;

class Node{
    int i;
    int v;

    Node(int i, int v) {
        this.i = i;
        this.v = v;
    }
}

public class MaximizeSum {

    static Scanner in = new Scanner(System.in);

    static int doStuff(){
        String[] props = in.nextLine().split(" ");
        int size = Integer.parseInt(props[0]);
        int mod = Integer.parseInt(props[1]);
        Node[] nums = new Node[size];
        String[] numsStr = in.nextLine().split(" ");
        int curr = 0;

        for(int i = 0 ; i < size ; i++){
            int val = Integer.parseInt(numsStr[i]);
            nums[i] = new Node(i, (curr + val)%mod);
            curr = (curr + val)%mod;
            System.out.println(curr);
        }

        Arrays.sort(nums, (Node r1, Node r2) -> r1.v - r2.v);

        int result = mod, next;
        for(int i = 0 ; i < size-1 ; i++) {
            System.out.println(nums[i].i + " " + nums[i+1].i);
            if(nums[i].i > nums[i+1].i){
                curr = nums[i].v;
                next = nums[i+1].v;
                if(next - curr < result && next - curr > 0){
                    result = next - curr;
                }
            }
        }
        return mod - result;
    }

    public static void main(String[] args) {
        int problems = Integer.parseInt(in.nextLine());
        for(int i = 0 ; i < problems ; i++){
            System.out.println(doStuff());
        }
    }
}
