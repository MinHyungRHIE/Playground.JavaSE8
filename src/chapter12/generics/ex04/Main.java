package chapter12.generics.ex04;

import java.util.ArrayList;
import java.util.Collection;

class Fruit{

    @Override
    public String toString(){
        return "Fruit";
    }
}

class Apple extends Fruit{
    @Override
    public String toString(){
        return "Apple";
    }
}

class Grape extends Fruit{
    @Override
    public String toString(){
        return "Grape";
    }
}

class Juice{
    String name;
    Juice(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

class Juicer{
    static Juice makeJuice(FruitBox<? extends Fruit> box){
        StringBuilder tmp = new StringBuilder();

        for(Fruit f : box.getList()){
            tmp.append(f).append(" ");
        }

        return new Juice(tmp.toString());
    }
}

class FruitBox<T extends Fruit> extends Box<T>{

}

public class Main {
    public static void main(String[] args) {
        FruitBox<Fruit> fruitBox = new FruitBox<>();
        FruitBox<Apple> appleBox = new FruitBox<>();

        fruitBox.add(new Apple());
        fruitBox.add(new Grape());
        appleBox.add(new Apple());
        appleBox.add(new Apple());

        System.out.println(Juicer.makeJuice(fruitBox));
        System.out.println(Juicer.makeJuice(appleBox));
        Collection<String> s;

    }
}
