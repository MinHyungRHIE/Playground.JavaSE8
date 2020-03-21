package chapter11.assort_collections;

import java.util.HashSet;

class Member{
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Member){
            Member mem = (Member)o;
            return this.name.equals(mem.name);
        }else{
            return false;
        }
    }

    @Override
    public int hashCode() {
        return 1;
    }
}

public class HashSetTest {
    public static void main(String[] args) {
        HashSet hs = new HashSet();
        Member m1 = new Member("AAA",10);
        Member m2 = new Member("BBB",11);
        Member m3 = new Member("CCC",12);
        Member m4 = new Member("AAA",12);

        hs.add(m1);
        hs.add(m2);
        hs.add(m3);
        hs.add(m4);

        System.out.println(hs);
        System.out.println(hs.size());
        //HashSet, Hashtable, HashMap 등 hashCode()->equals()순으로 비교해서 put||get
        //그러므로 hashCode() 오버라이딩은 정말 중요하다.
    }
}
