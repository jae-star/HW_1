package hw_1;

interface Insurable {
    void insure();
}

abstract class Vehicle {
    private final String nickname;

    public Vehicle(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public abstract void startEngine();

    public String description() {
        return "Vehicle: " + nickname;
    }
}

record Owner(String name, int age) {}

final class Car extends Vehicle implements Insurable {
    private final String model;
    private final int year;
    private final Owner owner;

    public Car(String nickname, String model, int year, Owner owner) {
        super(nickname);
        this.model = model;
        this.year = year;
        this.owner = owner;
    }

    public String getModel() { return model; }
    public int getYear() { return year; }
    public Owner getOwner() { return owner; }

    @Override
    public void startEngine() {
        System.out.println(getNickname() + " (" + model + " " + year + ") goes VROOM!");
    }

    @Override
    public void insure() {
        System.out.println("Insuring " + getNickname() + " under " + owner.name() + ".");
    }

    @Override
    public String toString() {
        return "Car{" +
            "nickname='" + getNickname() + '\'' +
            ", model='" + model + '\'' +
            ", year=" + year +
            ", owner=" + owner +
            '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Owner owner = new Owner("Ada", 20);
        Car car = new Car("Starlight", "Nimble", 2025, owner);

        System.out.println(owner.name() + " (" + owner.age() + ") owns: ");
        System.out.println(car);
        car.startEngine();
        car.insure();
    }
}
