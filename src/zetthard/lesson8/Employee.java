package zetthard.lesson8;

import java.util.Objects;

public abstract class Employee implements ICallable {
    public String name;
    private static int ID = 0;
    private final int employeeID;
    public String phoneNum;
    public boolean isAvailable = true;

    public int getEmployeeID() {
        return employeeID;
    }

    public Employee(String name, String phone) {
        this.name = name;
        this.phoneNum = phone;
        employeeID = ++ID;
    }

    @Override
    public void answerCall() {
        isAvailable = false;
    }

    @Override
    public void hangUp() {
        Objects.requireNonNull(PBXterminal.getInstance()).closeConnection(phoneNum);
    }
}

class Director extends Employee {
    public Director(String name, String phone) {
        super(name, phone);
    }

    @Override
    public void answerCall() {
        System.out.println("Call was answered by director");
    }
}

class Operator extends Employee {

    public Operator(String name, String phone) {
        super(name, phone);
    }

    @Override
    public void answerCall() {
        System.out.println("Call was answered by operator " + name + ", ID:" + getEmployeeID());
    }
}

class Manager extends Employee {

    public Manager(String name, String phone) {
        super(name, phone);
    }

    @Override
    public void answerCall() {
        System.out.println("Call was answered by manager " + name);
    }
}
