package dog.java.generic;

import java.util.ArrayList;
import java.util.Iterator;

class __Database<E>{

    ArrayList<E> table = new ArrayList<E>();

    //save
    void create(E model){
        table.add(model);
    }

    //find
    E[] read(){
        Iterator itr = table.iterator();
//        Schema[] result = new Schema[table.size()];
        while(itr.hasNext()){

        }
        return null;
    }

    void update(){

    }

    void delete(){

    }
}

class Box<T>{
    T item;

//    static T staticVar; //제네릭은 static이 불가하다

    T getItem(){
        return item;
    }

    void setItem(T item){
        this.item = item;
    }
}

interface Database<Schema>{
    //ArrayList<Schema> table = null; //제네릭은 static이 불가하다
    boolean create(Schema model);
    Schema[] read();
    boolean update(Schema model);
    boolean delete(Schema model);
}

class User {
    String username;
    String password;
//    Privilege<T> privilege; 그냥 이렇게 쓰면 사용할 수가 없음
//    Privilege<?> privilege; 이렇게 쓰면 모든 클래스가 들어올 수 있게 되버림
    Privilege<? extends Role> privilege;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Privilege<? extends Role> getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege<? extends Role> privilege) {
        this.privilege = privilege;
    }
}

interface Role{
//    int Admin=0, Member=1, Anonymous=2;

}

//인터페이스를 구현할 때 implements를 쓰지만 구현클래스, 추상클래스, 인터페이스 모두 extends로 통일. 클래스 선언 단계에서 &로 확장 가능
class Privilege<T extends Role>{
    T t;

}

class Admin implements Role{
//    String s = "Admin";
}
class Member implements Role{
//    String s = "Member";
}
class Anonymous implements Role{
//    String s = "Anonymous";
}

public class Main {
    public static void main(String[] args) {
        new Privilege<Admin>();
//        new Privilege<User>();

        /*
        String r = new Admin().s;
        System.out.println(r);
        User user = new User();
        user.setPrivilege(new Privilege<>());
        Privilege p = user.getPrivilege();
        p.t = new Admin();
        System.out.println(p.t instanceof Object);
        System.out.println(p.t.toString());
        */

    }
}

