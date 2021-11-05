package zetthard.lesson8;

import java.util.Objects;

public class Call {
    public String phoneNum;

    public Call(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void make() {
        System.out.println("Calling terminal...");
        Objects.requireNonNull(PBXterminal.getInstance()).dispatchCall(phoneNum);
    }

    public void hangUp() {
        Objects.requireNonNull(PBXterminal.getInstance()).closeConnection(phoneNum);
    }
}
