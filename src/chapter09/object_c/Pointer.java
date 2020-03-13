package chapter09.object_c;

import java.util.Arrays;

public class Pointer implements Cloneable{
    int x, y;
    int[] iArr;

    public Pointer(int x, int y) {
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
}
