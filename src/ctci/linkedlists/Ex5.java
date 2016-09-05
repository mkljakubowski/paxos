package ctci.linkedlists;

import java.util.Scanner;

class Node2 {
    Node2 n;
    int data;

    public Node2(Node2 n, int data) {
        this.n = n;
        this.data = data;
    }

    @Override
    public String toString() {
        if(n == null){
            return data+"";
        }
        return data + " " + n.toString();
    }

    public String toStringReverse() {
        if(n == null){
            return data+"";
        }
        return n.toString() + " " + data;
    }

}

public class Ex5 {

    static Scanner in = new Scanner(System.in);

    private static void sum(Node2 n1, Node2 n2) {
        Node2 l1 = n1, l2 = n2, c = null, h = null;
        int reminder = 0;
        while (l1 != null || l2 != null) {
            int sum;
            if(l1 != null && l2 != null){
                sum = l1.data + l2.data + reminder;
                l1 = l1.n;
                l2 = l2.n;
            }else{
                Node2 n = l1 == null ? l2 : l1;
                l1 = l1 == null ? l2.n : l1.n;
                sum = n.data + reminder;
            }
            reminder = sum / 10;
            if(c == null){
                c = new Node2(null, sum % 10);
                h = c;
            }else{
                c.n = new Node2(null, sum % 10);
                c = c.n;
            }
        }
        if(reminder != 0){
            c.n = new Node2(null, reminder);
        }
        System.out.println(h.toString());
    }

    public static void main(String[] args) {
        String line = in.nextLine();
        String x = in.nextLine();
        Node2 n = null;
        Node2 head1 = null;
        Node2 head2 = null;
        for (String w : line.split(" ")) {
            if (n == null) {
                n = new Node2(null, Integer.parseInt(w));
                head1 = n;
            } else {
                n.n = new Node2(null, Integer.parseInt(w));
                n = n.n;
            }
        }
        n = null;
        for (String w : x.split(" ")) {
            if (n == null) {
                n = new Node2(null, Integer.parseInt(w));
                head2 = n;
            } else {
                n.n = new Node2(null, Integer.parseInt(w));
                n = n.n;
            }
        }
        sum(head1, head2);
    }

}
