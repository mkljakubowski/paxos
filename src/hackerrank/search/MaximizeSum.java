package hackerrank.search;

import java.util.Arrays;
import java.util.Scanner;

class Node{
    long i;
    long v;

    Node(long i, long v) {
        this.i = i;
        this.v = v;
    }
}

public class MaximizeSum {

    static Scanner in = new Scanner(System.in);

    static long doStuff(){
        String[] props = in.nextLine().split(" ");
        int size = Integer.parseInt(props[0]);
        long mod = Integer.parseInt(props[1]);
        Node[] nums = new Node[size];
        String[] numsStr = in.nextLine().split(" ");
        long curr = 0;

        for(int i = 0 ; i < size ; i++){
            long val = Integer.parseInt(numsStr[i]);
            curr = (curr + val)%mod;
            nums[i] = new Node(i, curr);
        }

        Arrays.sort(nums, (Node r1, Node r2) -> (int)(r1.v - r2.v));

        long ret = mod;
        for(int i = 0; i < size-1; i++) {
            if(nums[i].i > nums[i+1].i){
                ret = Math.min(ret, (nums[i+1].v - nums[i].v + mod) % mod);
            }
            ret = Math.min(ret, nums[i].v);
        }

        return mod - ret;
    }

    public static void main(String[] args) {
        long problems = Integer.parseInt(in.nextLine());
        for(long i = 0 ; i < problems ; i++){
            System.out.println(doStuff());
        }
    }
}
