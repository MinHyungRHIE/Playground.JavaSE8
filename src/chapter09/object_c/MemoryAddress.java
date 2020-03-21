package chapter09.object_c;

import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;

public class MemoryAddress {
    public static void main(String[] args) {
        String strA = new String("Hello");
        String strB = new String("Hello");

        MemoryAddress ma1 = new MemoryAddress();
        MemoryAddress ma2 = new MemoryAddress();

        System.out.println(System.identityHashCode(strA));
        System.out.println(System.identityHashCode(strB));

        System.out.println(strA.hashCode());
        System.out.println(strB.hashCode());

        System.out.println(System.identityHashCode(ma1));
        System.out.println(System.identityHashCode(ma2));

        System.out.println(ma1.hashCode());
        System.out.println(ma2.hashCode());
    }
}
