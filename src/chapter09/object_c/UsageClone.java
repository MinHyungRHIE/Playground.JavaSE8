package chapter09.object_c;

import java.util.Arrays;

public class UsageClone implements Cloneable{
    int x, y;
    int[] iArr;

    public UsageClone(int x, int y) {
        this.x = x;
        this.y = y;
        this.iArr = new int[]{1,2,3};
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = null;
        try{
            obj = super.clone();    // clone()은 반드시 예외처리를 해주어야 한다
        }catch(CloneNotSupportedException e){
            System.out.println(e);
        }
        return obj;
    }

    @Override
    public String toString() {
        return "Pointer{" +
                "x=" + x +
                ", y=" + y +
                ", iArr=" + Arrays.toString(iArr) +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        UsageClone original = new UsageClone(3,5);
        UsageClone copy = (UsageClone)original.clone();
        copy.x = 10;
        copy.iArr[1] = 99;
        System.out.println(original);
        System.out.println(copy);
    }
}
