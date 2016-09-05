package ctci.linkedlists;

import java.util.HashSet;
import java.util.Scanner;

public class Ex6 {

    static Scanner in = new Scanner(System.in);

    private static Node2 cycle(Node2 list) {
        HashSet<Node2> set = new HashSet<>();
        Node2 n = list;
        while(n != null){
            if(set.contains(n)){
                return n;
            }
            set.add(n);
            n = n.n;
        }
        return null;
    }

    public static void main(String[] args) {
        Node2 n5 = new Node2(null, 5);
        Node2 n4 = new Node2(n5, 4);
        Node2 n3 = new Node2(n4, 3);
        Node2 n2 = new Node2(n3, 2);
        Node2 n1 = new Node2(n2, 1);
        Node2 head = new Node2(n1, 0);
        n5.n = n2;

        System.out.println(cycle(head).data);
    }

}
