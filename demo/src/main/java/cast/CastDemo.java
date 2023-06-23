package cast;

public class CastDemo {

    /**
     * 1、在引用数据类型中，只有有继承关系的类型才能进行类型转换；
     *
     * 类型转换只是转换看待对象的引用的类型，对象本身没有也不可能参与转换；
     *
     * 2、父类引用可以自动指向子类对象，但只能访问和调用到来自于父类的属性和行为；
     *
     * 3、子类的引用不能指向父类或其它子类对象，就算强转也会导致运行失败并抛出ClassCastException；
     *
     * 3、把父类引用赋给子类引用，语法上必须使用强制类型转换，要想运行也成功还必须保证父类引用指向的对象一定是该子类对象（最好使用instance判断后，再强转）
     */

    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.move();

        Cat cat1 = (Cat) cat;
        cat1.speak();

        Animal animal = new Animal();
//        cast.Cat animal1 = (cast.Cat) animal;

        Animal bird = new Bird();
//        cast.Cat bird1 = (cast.Cat) bird;

        System.out.println(cat instanceof Cat);

        System.out.println(cat instanceof Animal);

        System.out.println(bird instanceof Animal);

        System.out.println(bird instanceof Cat);

        System.out.println(animal instanceof Cat);
    }

}

class Animal {
    public void move() {
        System.out.println("animal can move");
    }
}

class Cat extends Animal {
    @Override
    public void move() {
        System.out.println("cat move");
    }

    public void speak() {
        System.out.println("cat miao miao");
    }
}

class Bird extends Animal {
    @Override
    public void move() {
        System.out.println("bird move");
    }

    public void fly() {
        System.out.println("bird fly");
    }
}

