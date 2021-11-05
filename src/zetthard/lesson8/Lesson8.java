package zetthard.lesson8;

public class Lesson8 {
    public static void main(String[] args) {

        PBXterminal terminal1 = PBXterminal.getInstance(5,2);
        terminal1.initialize(5,2,"Ivan Ivanovich");
        Call call1 = new Call("12345");
        call1.make();
        System.out.println();
        Call call2 = new Call("24567");
        call2.make();
        System.out.println();
        Call call3 = new Call("34678");
        call3.make();
        System.out.println();
        terminal1.closeConnection(terminal1.connections.get(0));
        System.out.println();
        Call call4 = new Call("45689");
        call4.make();
        System.out.println();
        Call call5 = new Call("58912");
        call5.make();
        System.out.println();
        Call call6 = new Call("67923");
        call6.make();
        System.out.println();
        Call call7 = new Call("78534");
        call7.make();
        System.out.println();
        Call call8 = new Call("89455");
        call8.make();
        System.out.println();
        Call call9 = new Call("91235");
        call9.make();
        System.out.println();
        Call call10 = new Call("05427");
        call10.make();
        System.out.println(terminal1.connections);
        System.out.println();
        terminal1.operators[2].hangUp();
        System.out.println(terminal1.connections);
        System.out.println();
        call10.make();
        System.out.println(terminal1.connections);
        System.out.println(terminal1.operators[3].isAvailable);
        terminal1.operators[3].hangUp();
        System.out.println(terminal1.operators[3].isAvailable);
        terminal1.operators[0].hangUp();
        terminal1.managers[1].hangUp();
        System.out.println(terminal1.connections);
    }
}
