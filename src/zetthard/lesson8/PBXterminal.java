package zetthard.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//singleton implementation of central PBX terminal
public final class PBXterminal {
    private static PBXterminal instance;
    public Operator[] operators;
    public Manager[] managers;
    public Director director;
    public List<Connection> connections;

    private PBXterminal(int ops, int mans) {
        operators = new Operator[ops];
        managers = new Manager[mans];
        connections = new ArrayList<>();
    }

    //calling helper initializer to populate terminal with employees
    public void initialize(int ops, int mans, String director) {
        EmployeeInitializer init = new EmployeeInitializer();
        init.populateTerminal(ops,mans,director);
    }

    //accessor that actually calls constructor
    public static PBXterminal getInstance(int operatorsCount, int managersCount) {
        if (instance == null) {
            instance = new PBXterminal(operatorsCount, managersCount);
        }
        return instance;
    }
    //parameterless accessor for use in client's code.
    public static PBXterminal getInstance() {
        try {
            return instance;
        }
        catch (NullPointerException ex) {
            System.out.println("No instance of terminal is initialized. " +
                    "Please create terminal first using parameterized constructor.");
            return getInstance(0,0);
        }
    }

    //Tries to connect caller to any employee.
    public void dispatchCall(String callerNum) {
        System.out.println("New incoming call from " + callerNum);
        Connection newConn;
        Employee employee;
        try {
            System.out.println("Getting first available operator...");
            employee = getAvailableEmployee();
        }
        catch (NullPointerException ex) {
            employee = null;
        }
        /*using concrete employee, call connect() method, add returned connection to collection of connections
        and set that employee's isAvailable field to false.*/
        if (employee != null) {
            System.out.println("Connecting...");
            newConn = connect(callerNum, employee.phoneNum);
            employee.isAvailable = false;
            employee.answerCall();
            connections.add(newConn);
        } else if (director.isAvailable) {
            newConn = connect(callerNum, director.phoneNum);
            director.isAvailable = false;
            director.answerCall();
            connections.add(newConn);
        } else {
            System.out.println("All lines are busy, please wait...");
        }
    }

    //Establish connection between caller and employee using their phone numbers.
    private Connection connect(String callerNum, String employeeNum) {
        return new Connection(callerNum, employeeNum);
    }

    /*Search for an employee with phone number related to passed connection,
    and sets it's isAvailable property back to true.
    This method is clunky and not DRY because my connections are defined
    based on connected classes properties. And classes may vary. Also, there is no
    single collection of all employees in PBXterminal class. Poor design.*/
    public void closeConnection(Connection connection) {
        //Extract the number from connection
        String activeEmployee = connection.employeeNum;
        //Find employee with this number
        if (Objects.equals(director.phoneNum, activeEmployee)) {
            director.isAvailable = true;
        }
        for (Employee emp :
                managers) {
            if (Objects.equals(emp.phoneNum, activeEmployee)) {
                emp.isAvailable = true;
            }
        }
        for (Employee emp :
                operators) {
            if (Objects.equals(emp.phoneNum, activeEmployee)) {
                emp.isAvailable = true;
            }
        }
        connections.remove(connection);
        System.out.println("Connection is closed");
    }

    //Overloaded method for calling from Employee or Call class
    public void closeConnection(String number) {
        Connection connection = null;
        for (Connection c :
                connections) {
            if (Objects.equals(c.employeeNum, number) || Objects.equals(c.callerNum, number)) {
                connection = c;
            }
        }
        assert connection != null;
        if (Objects.equals(director.phoneNum, connection.employeeNum)) { director.isAvailable = true; }
        for (Manager man :
                managers) {
            if (Objects.equals(man.phoneNum, connection.employeeNum)) {
                man.isAvailable = true;
            }
        }
        for (Operator op :
                operators) {
            if (Objects.equals(op.phoneNum, connection.employeeNum)) {
                op.isAvailable = true;
            }
        }
        connections.removeIf(c -> Objects.equals(c.employeeNum, number) || Objects.equals(c.callerNum, number));
    }

    //Search if there is any available employee among operators and managers.
    private Employee getAvailableEmployee() {
        for (Operator op :
                operators) {
            if (op.isAvailable) {
                return op;
            }
        }
        for (Manager man:
             managers) {
            if (man.isAvailable) {
                return man;
            }
        }
        return null;
    }
}
