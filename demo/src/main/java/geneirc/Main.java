package geneirc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static <T extends Comparable<T>> void sort1(List<T> list) {
        Collections.sort(list);
    }

    public static <T extends Comparable<? super T>> void sort2(List<T> list) {
        Collections.sort(list);
    }

    public static void main(String[] args) {

        int i = 24 >>> 1;



        System.out.println(i);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog(12));
        dogs.add(new Dog(13));


        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal(12));
        animals.add(new Animal(13));

        List<Object> objs = new ArrayList<>();
        objs.add(new Object());
        objs.add(new Object());


        sort1(animals);
//        sort1(dogs);
        sort2(dogs);

//        sort2(dogs);
    }

    static class Dog extends Animal {
        public Dog(int age) {
            super(age);
        }
    }


    static class Animal implements Comparable<Animal> {
        private int age;

        public Animal(int age) {
            this.age = age;
        }

        @Override
        public int compareTo(Animal o) {
            return 0;
        }
    }

}
