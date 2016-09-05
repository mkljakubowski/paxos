package ctci.linkedlists;

import java.util.Scanner;
import java.util.Stack;

public class Ex7 {

    static Scanner in = new Scanner(System.in);

    private static boolean isPalindrome(Node list) {
        Node h = list, n;
        Stack<Node> stack = new Stack<>();
        while(h != null){
            stack.push(h);
            h = h.n;
        }
        int size = stack.size();
        int curSize = 0;
        h = list;
        while(h != null && curSize + curSize <= size){
            n = stack.pop();
            if(!n.data.equals(h.data)){
                return false;
            }
            curSize++;
            h = h.n;
        }
        return true;
    }

    public static void main(String[] args) {
        String line = in.nextLine();
        Node n = null;
        Node head = null;
        for (String w : line.split(" ")) {
            if (n == null) {
                n = new Node(null, w);
                head = n;
            } else {
                n.n = new Node(null, w);
                n = n.n;
            }
        }
        System.out.println(isPalindrome(head));
    }

}
