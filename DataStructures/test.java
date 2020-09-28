// import java.util.*;
import com.DataStructures.*;

public class test {

    int[] arr2 = new int[4];
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list.add(98);
        list.add(56);
        list.add(0,45);
        list2.add(45);
        list2.add(98);
        list2.add(56);
        // list.set(7, 89);
        test t = new test();
        t.arr2[1] = 1;
        //ArrayList tests
        System.out.println("rem 98: "+list.remove(Integer.valueOf(98)));
        System.out.println("string: "+list.toString());
        System.out.println("98: "+list.contains(98));
        System.out.println("[0]: "+list.get(0));
        System.out.println("98pos: "+list.indexOf(98));
        System.out.println("eq: "+list.equals(list2));
        System.out.println("(0, 45->67): "+list.set(0, 67));
        System.out.println("size: "+list.size());
        System.out.println("1:3 -> "+list.sublist(1, 3));
        Integer[] tmp = new Integer[4];
        list.toArray(tmp);
        list.clear();
        System.out.println(list.toString());
    }
}
