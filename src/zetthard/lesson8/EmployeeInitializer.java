package zetthard.lesson8;

import java.util.Objects;

//helper class. Populate terminal with employees foe testing purpose
public class EmployeeInitializer {
    String[] names1 = new String[]{"Anton", "Maria"};
    String[] names2 = new String[]{"Anna", "Boris", "Egor", "Daria", "Dmitriy"};
    String[] phones = new String[]{"00001", "00002", "00003", "00004", "00005", "00006", "00007", "00008"};

    public void populateTerminal(int ops, int mans, String director) {
        Objects.requireNonNull(PBXterminal.getInstance()).director = new Director(director, phones[0]);
        for (int i = 0; i < mans; i++) {
            Objects.requireNonNull(PBXterminal.getInstance()).managers[i] = new Manager(names1[i], phones[i+1]);
        }
        for (int i = 0; i < ops; i++) {
            Objects.requireNonNull(PBXterminal.getInstance()).operators[i] = new Operator(names2[i], phones[i+1+mans]);
        }
    }
}
