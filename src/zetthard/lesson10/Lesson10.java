package zetthard.lesson10;

import java.lang.reflect.Type;
import java.util.*;

public class Lesson10 {
    public static void main(String[] args) {

        //10.1 test
        /*List<String> set1 = List.of("Anna", "Andrey", "Mikhail", "Andrey", "Ivan", "Ivan");
        System.out.println(set1);
        System.out.println(duplicateRemover(set1));
        System.out.println();*/

        //10.2 test
        /*List<Integer> intList1 = new ArrayList<>();
        List<Integer> intLinkedList1 = new LinkedList<>();
        populateCollection(intList1, 1000000); //instant result
        System.out.println(getRandomElmt(intList1));
        populateCollection(intLinkedList1, 1000000); //more than 1 minute.
        System.out.println(getRandomElmt(intLinkedList1));
        System.out.println();*/
        //Random read efficiency of linked list is O(n) while for ArrayList it's O(1).

        //10.3 test
        /*Game game1 = new Game();
        game1.playGame();
        game1.getScores();*/

        //10.4 test
        Integer[] objects1 = {20, 20, 34, 40, 25, 36, 40, 54, 34, 25, 40, 34};
        System.out.println("Input array: " + Arrays.toString(objects1));
        System.out.println("Map: " + arrayToMap(objects1));
        System.out.println();
        String[] objects2 = {"I", "learn", "Java", "and", "learn", "C#", "too"};
        System.out.println("Input array: " + Arrays.toString(objects2));
        System.out.println("Map: " + arrayToMap(objects2));
    }

    //10.1
    public static <K> HashSet<K> duplicateRemover(List<K> list) {
        return new HashSet<>(list);
    }

    //10.2
    public static void populateCollection(List<Integer> list, int count) {
        Random rnd = new Random();
        for (int i = 0; i <= count; i++) {
            list.add(rnd.nextInt());
        }
    }

    public static <K> K getRandomElmt(List<K> list) {
        Random rnd = new Random();
        K res = null;
        int index;
        for (int i = 0; i <= 10000; i++) {
            index = rnd.nextInt(0, list.size());
            res = list.get(index);
        }
        return res;
    }

    //10.4
    public static <K> Map<K, Integer> arrayToMap(K[] ks) {
        HashMap<K, Integer> map = new HashMap<>();
        for (K elmnt :
                ks) {
            if (map.containsKey(elmnt)) {
                map.replace(elmnt, map.get(elmnt)+1);
            } else { map.put(elmnt, 1); }
        }
        return map;
    }
}

//10.3
class Game {
    HashMap<User, Integer> scores = new HashMap<>();
    List<User> users = new ArrayList<>();
    public void playGame() {
        User andrey = new User("Andrey");
        User ivan = new User("Ivan");
        User yulia = new User("Yulia");
        User sasha = new User("Sasha");

        users.add(andrey);
        users.add(ivan);
        users.add(yulia);
        users.add(sasha);

        scores.put(andrey, 45);
        scores.putIfAbsent(ivan, 47);
        scores.putIfAbsent(yulia, 48);
        scores.putIfAbsent(sasha, 40);

        StringBuilder sb1 = new StringBuilder("Today playing: { ");
        for (User user :
                users) {
            sb1.append(user.getName()).append(", ");
        }
        sb1.replace(sb1.length()-2, sb1.length()-1, " }");
        System.out.println(sb1);
    }

    public void getScores() {
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (true) {
            System.out.println("Enter name to view player's score (or 'quit' to exit)");
            try {
                input = sc.nextLine();
                input = input.toLowerCase();
            }
            catch (Exception e){
                System.out.println("Invalid input");
            }
            if (Objects.equals(input, "quit")) { return; }

            User usr = new User("default");
            for (User u :
                    users) {
                if (Objects.equals(u.getName().toLowerCase(), input)) {
                    usr = u;
                    break;
                }
            }
            if (Objects.equals(usr.getName(), "default")) {
                System.out.println("User not found");
            } else if (scores.containsKey(usr)) {
                    System.out.printf("%s's score is: %d", usr.getName(), scores.get(usr));
                    System.out.println();
            } else {
                System.out.println("No score registered for player");
            }
        }
    }
}

//Custom class for 10.3
class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
