package zetthard.lesson6;

import java.time.LocalDate;
import java.time.Period;


public class Lesson6 {
    public static void main(String[] args) {

        //6.1 test
        Study studyObj = new Study("Learning Java is easy!");
        System.out.println(studyObj.printCourse());
        System.out.println();

        //6.2 test
        /*House house1 = new House();
        house1.setName("Building 1");
        house1.setFloors(9);
        house1.setYearBuild(LocalDate.of (2010, 8, 7));

        House house2 = new House();
        house2.setName("Hotel \"Smart Hotel\"");
        house2.setFloors(18);
        house2.setYearBuild(LocalDate.of (2003, 5, 15));

        StringBuilder sb1 = new StringBuilder();
        sb1.append(house1.getName()).append(", ")
                .append(house1.getFloors()).append(" floors, ")
                .append(house1.getYearBuild());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(house2.getName()).append(", ")
                .append(house2.getFloors()).append(" floors, ")
                .append(house2.getYearBuild());

        System.out.println(sb1);
        System.out.printf("Age: %d years", house1.age());
        System.out.println();
        System.out.println();
        System.out.println(sb2);
        System.out.printf("Age: %d years", house2.age());*/

        //6.3 test
        /*Tree tree1 = new Tree("Oak", 50);
        System.out.println(tree1);
        Tree tree2 = new Tree("Maple", 40, true);
        System.out.println(tree2);
        Tree tree3 = new Tree();*/

        //6.4 test
        /*Plane a380 = new Plane();
        Plane.Wing lightWing100 = a380.new Wing();
        lightWing100.weight = 100.4;
        Plane.Wing mediumWing130 = a380.new Wing();
        mediumWing130.weight = 130.5;

        lightWing100.showWeight();
        mediumWing130.showWeight();*/

    }
}

//6.1
class Study {

    private String course;

    public Study(String str) {
        course = str;
    }

    public String printCourse() {
        return this.course;
    }
}

//6.2
class House {

    private String name;
    private int numberOfFloors;
    private LocalDate yearBuild;

    public int getFloors() {
        return numberOfFloors;
    }

    public void setFloors(int floor) {
        this.numberOfFloors = floor;
    }

    public LocalDate getYearBuild() {
        return yearBuild;
    }

    public void setYearBuild(LocalDate yearBuild) {
        this.yearBuild = yearBuild;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int age() {

        LocalDate today = LocalDate.now();
        return Period.between(yearBuild, today).getYears();
    }
}

class Tree {

    private String name;
    private int age;
    private boolean isAlive;

    public Tree(String name, int age) {
        this.name = name;
        this.age = age;
        this.isAlive = true;
    }
    public Tree(String name, int age, boolean alive) {
        this.name = name;
        this.age = age;
        this.isAlive = alive;
    }

    public Tree() {
        System.out.println("Parameterless constructor was called");
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isAlive=" + isAlive +
                '}';
    }
}

class Plane {

    public class Wing {

        public double weight;

        public void showWeight() {
            System.out.println(this.weight);
        }
    }
}