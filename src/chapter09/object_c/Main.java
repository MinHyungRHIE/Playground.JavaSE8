package chapter09.object_c;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Pointer original = new Pointer(3,5);
        Pointer copy = (Pointer)original.clone();
        copy.x = 10;
        copy.iArr[1] = 99;
        System.out.println(original);
        System.out.println(copy);
    }
}
