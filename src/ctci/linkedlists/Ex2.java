package ctci.linkedlists;

import java.util.*;

class Node {
    Node n;
    String data;

    public Node(Node n, String data) {
        this.n = n;
        this.data = data;
    }

    @Override
    public String toString() {
        if(n == null){
            return data;
        }
        return data + " " + n.toString();
    }

    public String toStringReverse() {
        if(n == null){
            return data;
        }
        return n.toString() + " " + data;
    }

}

public class Ex2 {

    static Scanner in = new Scanner(System.in);

    private static String findDuplicates1(Node list, int x){
        Node n = list;
        for(;x > 0 ; x--){
            if(n.n == null) {
                throw new IndexOutOfBoundsException();
            } else {
                n = n.n;
            }
        }
        return n.data;
    }

    public static void main(String[] args) {
        String line = in.nextLine();
        int x = Integer.parseInt(in.nextLine());
        Node n = null;
        Node head = null;
        for(String w : line.split(" ")){
            if(n == null){
                n = new Node(null, w);
                head = n;
            }else{
                n.n = new Node(null, w);
                n = n.n;
            }
        }
        System.out.println(findDuplicates1(head, x));
    }
}
