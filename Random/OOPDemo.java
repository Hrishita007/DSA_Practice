//oop demo
abstract class Animal {
    private String name;

    Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    abstract void makeSound();
}

class Dog extends Animal {

    Dog(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }
}

class Cat extends Animal {

    Cat(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(getName() + " says: Meow!");
    }
}

public class OOPDemo {
    public static void main(String[] args) {

        Animal dog = new Dog("Buddy");
        Animal cat = new Cat("Kitty");

        dog.makeSound();
        cat.makeSound();
    }
}

