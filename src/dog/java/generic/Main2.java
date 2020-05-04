package dog.java.generic;

class Alphabet{}
class A extends Alphabet{}
class B extends Alphabet{}
class C extends Alphabet{}
class Other{}
class Case<T>{}

class Person{}
class Adult extends Person{}
class Creator extends Adult{}

class BasicRoleGeneric<T>{

    T item;

    T getItem(){
        return this.item;
    }

    void setItem(T t){
        this.item = item;
    }

    /*1. static 사용불가*/
//    static T item;

    /*2. new 생성 불가*/
//    T[] t = new T[10];
}

class LimitGeneric<T extends Alphabet>{}

class OverloadingGeneric{
    //오버로딩이 불가하다.
    /*
    void doSomething(Case<A> cs){}
    void doSomething(Case<B> cs){}
    void doSomething(Case<C> cs){}
    */
    void doSomething(Case<?> cs){}
    void superAlphabet(Case<? super Alphabet> cs){}
    void extendsAlphabet(Case<? extends Alphabet> cs){}
    void testExtends(Case<? extends Adult> cs){}
}

class methodOfGeneric{
    static <T> void doSomething(T t){
        System.out.println(t);
    }

    static <T extends Adult> void adultMethod(T t){
        System.out.println(t);
    }
}

class classWithMethodOfGeneric<T extends Person>{
    static <T> void doSomething(T t, Case<T> tt){
        System.out.println(t);
        System.out.println(tt);
    }

    void classMethod(T t){
        System.out.println(t);
    }
    static void staticMethod(){
        System.out.println("Test finish");
    }
}

public class Main2 {
    public static void main(String[] args) {
        LimitGeneric lg0 = new LimitGeneric<Alphabet>();
        LimitGeneric lg1 = new LimitGeneric<A>();
        LimitGeneric lg2 = new LimitGeneric<B>();
        LimitGeneric lg3 = new LimitGeneric<C>();
//        LimitGeneric lg4 = new LimitGeneric<Other>(); //Error

        Case obj = new Case(); // = Case<? extends Object>
        Case<Alphabet> alpha = new Case<Alphabet>();
        Case<A> a = new Case<A>();
        Case<B> b = new Case<B>();
        Case<C> c = new Case<C>();

        new OverloadingGeneric().doSomething(a);
        new OverloadingGeneric().doSomething(b);
        new OverloadingGeneric().doSomething(c);

        //제네릭의 다형성
        Alphabet alphabetA = new A();
        Alphabet alphabetB = new B();
        Alphabet alphabetC = new C();
        alphabetA = alphabetC;

        //...but
//        Case<Alphabet> abc = new Case<A>(); //Error
//        a = b; //Error a of Case<A>, b of Case<B>

        new OverloadingGeneric().superAlphabet(obj);
        new OverloadingGeneric().superAlphabet(alpha);
//        new OverloadingGeneric().superAlphabet(a); //Error
//        new OverloadingGeneric().superAlphabet(b); //Error
//        new OverloadingGeneric().superAlphabet(c); //Error

        new OverloadingGeneric().extendsAlphabet(obj); //Alphabet의 부모는  Object
        new OverloadingGeneric().extendsAlphabet(alpha);
        new OverloadingGeneric().extendsAlphabet(a);
        new OverloadingGeneric().extendsAlphabet(b);
        new OverloadingGeneric().extendsAlphabet(c);

        Case<Person> person = new Case<Person>();
        Case<Adult> adult = new Case<Adult>();
        Case<Creator> creator = new Case<Creator>();

        new OverloadingGeneric().testExtends(obj);
//        new OverloadingGeneric().testExtends(person); //Error
        new OverloadingGeneric().testExtends(adult);
        new OverloadingGeneric().testExtends(creator);

        methodOfGeneric.<Alphabet>doSomething(new Alphabet());
//        methodOfGeneric.<Alphabet>doSomething(new Other()); //Error
//        methodOfGeneric.<Alphabet>adultMethod(new Adult()); //Error
        methodOfGeneric.<Adult>adultMethod(new Adult());
        classWithMethodOfGeneric.<Alphabet>doSomething(new A(), new Case<Alphabet>());
//        new classWithMethodOfGeneric().classMethod(new B()); //Error
        new classWithMethodOfGeneric<Adult>().classMethod(new Adult());

        Case<?> C = new Case<A>();
        Case<B> B = (Case<B>)C;

    }

}
