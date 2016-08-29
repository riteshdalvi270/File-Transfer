package third.crackingcode.stackqueue;

import java.util.*;
import java.util.Queue;

/**
 * Animal Shelter.
 * Created by ritesh on 1/2/16.
 */
public class AnimalShelter {

    public static void main(String args[]) {

        Shelter shelter = new Shelter();
        shelter.enqueue("dogs",new Dogs("wolf"));
        shelter.enqueue("cats",new Cat("mountaincatty"));
        shelter.enqueue("dogs",new Dogs("mountaindogge"));
        shelter.enqueue("cats",new Cat("wolfcatty"));
        shelter.enqueue("dogs",new Dogs("kitty"));
        shelter.enqueue("cats",new Cat("doggy"));

        Animal animal = shelter.dequeueAny();
        System.out.println("DequeAny:"+animal.breed);

        try {
            Animal animal1 = shelter.dequeueDog();
            System.out.println("DequeAny:"+animal1.breed);

            Animal animal2 = shelter.dequeueCat();
            System.out.println("DequeAny:"+animal2.breed);
        }catch (final Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class Shelter {

    Queue<Dogs> dogs = new ArrayDeque<>();
    Queue<Cat> cats = new ArrayDeque<>();

    public void enqueue(String animalType, final Animal animal) {

        if (animalType.equalsIgnoreCase("DOGS")) {

            dogs.add((Dogs) animal);
        } else if (animalType.equalsIgnoreCase("CATS")) {

            cats.add((Cat)animal);
        } else {
            System.out.println("We do not shelter:" + animal);
        }

    }

    public Animal dequeueAny() {

        if(dogs.isEmpty()) {
            System.out.println("Dogs are not longer available, handing over the cat");
            return cats.remove();
        } else {
            return dogs.remove();
        }
    }

    public Animal dequeueDog() throws Exception {

        if(dogs.isEmpty()) {

            System.out.println("");
            throw new Exception("Dogs are not longer available");
        }
        return dogs.remove();
    }


    public Animal dequeueCat() throws Exception {

        if(dogs.isEmpty()) {

            System.out.println("");
            throw new Exception("Dogs are not longer available");
        }
        return cats.remove();
    }
}

class Dogs extends Animal {

    String breed;
    int age;

    public Dogs(String breed) {
        super(breed);
    }
}

class Cat extends Animal {
    String breed;
    int age;

    public Cat(String breed) {
       super(breed);
    }
}

class Animal {

    String breed;
    String name;

    public Animal(final String breed) {
        this.breed = breed;
    }

}
