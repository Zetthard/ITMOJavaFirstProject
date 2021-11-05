package zetthard.lesson8;

import java.util.Objects;

class Connection {
    private static int ID = 0;
    public String employeeNum;
    public String callerNum;
    private final int connectionID;

    public int getID() {
        return connectionID;
    }

    public Connection(String callerNum, String employeeNum) {
        this.employeeNum = employeeNum;
        this.callerNum = callerNum;
        connectionID = ++ID;
        System.out.println("Connection established");
    }

    public void cancel() {
        Objects.requireNonNull(PBXterminal.getInstance()).closeConnection(this);
    }

    public String toString() {
        return String.valueOf(getID());
    }
}
