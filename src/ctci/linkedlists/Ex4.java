package ctci.linkedlists;

import java.util.Scanner;

public class Ex4 {

    static Scanner in = new Scanner(System.in);

    private static void partition(Node list, String x) {
        Node l1 = null, l2 = null, c = list, l1h = null, l2h = null;
        while (c != null) {
            if (c.data.compareTo(x) > 0) {
                if(l1 == null){
                    l1 = new Node(null, c.data);
                    l1h = l1;
                } else {
                    l1.n = new Node(null, c.data);
                    l1 = l1.n;
                }
            } else {
                if(l2 == null){
                    l2 = new Node(null, c.data);
                    l2h = l2;
                } else {
                    l2.n = new Node(null, c.data);
                    l2 = l2.n;
                }
            }
            c = c.n;
        }
        System.out.println(l1h.toString());
        System.out.println(l2h.toString());
    }

    public static void main(String[] args) {
        String line = in.nextLine();
        String x = in.nextLine();
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
        partition(head, x);
    }

}
