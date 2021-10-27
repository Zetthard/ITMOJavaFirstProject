package zetthard.lesson7;

public class Car {
    public int weight;
    public String model;
    public char color;
    public float speed;

    public void outPut() {
        System.out.println("Weight " + model + " is " + weight + "kg.");
        System.out.println("Vehicle color - " + color + " and it's speed - " + speed);
    }

    public Car(int weight, String model, char color, float speed) {
        this.weight = weight;
        this.model = model;
        this.color = color;
        this.speed = speed;
    }

    public Car() {}
}

class Truck extends Car {
    public int wheelsCount;
    public int maxWeight;

    public void newWheels(int n) {
        this.wheelsCount = n;
        System.out.println(this.model + " has " + wheelsCount + " wheels.");
    }

    public Truck(int weight, String model, char color, float speed, int wheelsCount, int maxWeight) {
        super(weight, model, color, speed);
        this.wheelsCount = wheelsCount;
        this.maxWeight = maxWeight;
    }
}
