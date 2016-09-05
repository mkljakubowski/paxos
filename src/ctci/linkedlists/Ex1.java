package ctci.linkedlists;

import java.util.*;

public class Ex1 {

    static Scanner in = new Scanner(System.in);

    private static List<String> findDuplicates1(List<String> list){
        HashSet<String> hs = new HashSet<>();
        List<String> result = new LinkedList<>();
        for (String elem : list) {
            if (!hs.contains(elem)) {
                result.add(elem);
            }
            hs.add(elem);
        }
        return result;
    }

    private static List<String> findDuplicates2(List<String> list){
        List<String> result = new LinkedList<>();
        Collections.sort(list);
        for (String elem : list) {
            if (result.size() == 0 || !result.get(result.size()-1).equals(elem)) {
                result.add(elem);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String line = in.nextLine();
        List<String> list = Arrays.asList(line.split(" "));
        System.out.println(String.join(" ", findDuplicates2(list)));
    }
}
