package ctci.linkedlists;

import java.util.*;

public class Ex3 {

    static Scanner in = new Scanner(System.in);

    private static Node findDuplicates1(Node list, String x){
        Node n = list, prev = null;
        while(n != null){
            if(n.data.equals(x)){
                if(prev == null) {
                    return n.n;
                } else {
                    prev.n = n.n;
                    return list;
                }
            }
            prev = n;
            n = n.n;
        }
        return list;
    }

    public static void main(String[] args) {
        String line = in.nextLine();
        String x = in.nextLine();
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
