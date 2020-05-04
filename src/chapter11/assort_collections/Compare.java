package chapter11.assort_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Example implements Comparator<Integer> {
    int value;

    @Override
    public int compare(Integer o1, Integer o2) {
        if(o1 > o2) return -1;
        else if(o1 < o2) return 1;
        else if(o1 == o2) return 1;
        return 0;
    }
}

public class Compare {

    public static void main(String[] args) {
        System.out.println(new Example().compare(10,20));
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(3);
        al.add(2);
        al.add(5);
        al.add(4);
        System.out.println(al);
        Collections.sort(al,(o1, o2) -> {
            Integer fac1 = (Integer)o1;
            Integer fac2 = (Integer)o2;
            if(fac1 > fac2) return -1;
            if(fac1 < fac2) return 1;
            else return 0;
        });
        System.out.println(al);
    }

}