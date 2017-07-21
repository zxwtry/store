import java.util.*;
import java.util.stream.*;

public class Page0984_stream_map {
    public static void main(String[] args) {
        //List<Integer> myList = Arrays.asList(67, 69, 1, 2, 8);
        //integerStreamMapDoubleStream(myList);
        //integerStreamMapSqrtStream(myList);
        //namePhoneEmailMapNamePhone();
        //namePhoneEmailMapNamePhone2();
        //namePhoneList();
        namePhoneSet();
    }
    public static void integerStreamMapDoubleStream(List<Integer> myList) {
        Stream<Double> doubleStream = myList.stream().map((a) -> (double) a);
        double sum = doubleStream.reduce(0.0, (a, b) -> a + b);
        System.out.println(sum);
    }
    public static void integerStreamMapSqrtStream(List<Integer> myList) {
        Stream<Double> doubleStream = myList.stream().map((a) -> Math.sqrt((double) a)).parallel();
        double sum = doubleStream.reduce(
            1.0,
            (a, b) -> a * b * b,
            (a, b) -> a + b
        );
        System.out.println(sum);
    }
    static class NamePhoneEmail {
        String name;
        String phone;
        String email;
        public NamePhoneEmail(String name, String phone, String email) {
            this.name = name;
            this.phone = phone;
            this.email = email;
        }
    }
    static class NamePhone {
        String name;
        String phone;
        public NamePhone(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
    public static void namePhoneEmailMapNamePhone() {
        List<NamePhoneEmail> myList = new LinkedList<>();
        myList.add(new NamePhoneEmail("name01", "phone01", "email01"));
        myList.add(new NamePhoneEmail("name02", "phone02", "email02"));
        myList.add(new NamePhoneEmail("name03", "phone03", "email03"));
        myList.add(new NamePhoneEmail("name04", "phone04", "email04"));
        myList.add(new NamePhoneEmail("name05", "phone05", "email05"));
        myList.add(new NamePhoneEmail("name06", "phone06", "email06"));
        myList.add(new NamePhoneEmail("name07", "phone07", "email07"));
        Stream<NamePhone> namePhoneStream = myList.stream().map((a) -> new NamePhone(a.name, a.phone)).unordered();
        namePhoneStream.forEach((a) -> System.out.println(a.name + "..." + a.phone));
    }
    public static void namePhoneEmailMapNamePhone2() {
        List<NamePhoneEmail> myList = new LinkedList<>();
        myList.add(new NamePhoneEmail("name01", "phone01", "email01"));
        myList.add(new NamePhoneEmail("name02", "phone02", "email02"));
        myList.add(new NamePhoneEmail("name03", "phone03", "email03"));
        myList.add(new NamePhoneEmail("name04", "phone04", "email04"));
        myList.add(new NamePhoneEmail("name05", "phone05", "email05"));
        myList.add(new NamePhoneEmail("name06", "phone06", "email06"));
        myList.add(new NamePhoneEmail("name07", "phone07", "email07"));
        Stream<NamePhone> namePhoneStream = myList.stream()
            .filter((a) -> a.name.equals("name02"))
            .map((a) -> new NamePhone(a.name, a.phone)).unordered();
        namePhoneStream.forEach((a) -> System.out.println(a.name + "..." + a.phone));
    }
    public static void namePhoneList() {
        List<NamePhone> myList = new LinkedList<>();
        myList.add(new NamePhone("name01", "phone01"));
        myList.add(new NamePhone("name02", "phone02"));
        myList.add(new NamePhone("name03", "phone03"));
        myList.add(new NamePhone("name04", "phone04"));
        myList.add(new NamePhone("name05", "phone05"));
        List<NamePhone> newList = myList.stream().collect(
            () -> new ArrayList<NamePhone>(),
            (list, ele) -> list.add(ele),
            (listA, listB) -> listA.addAll(listB)
        );
        for (NamePhone np : newList) {
            System.out.println(np.name + "  " + np.phone);
        }
    }
    public static void namePhoneSet() {
        List<NamePhone> myList = new LinkedList<>();
        myList.add(new NamePhone("name01", "phone01"));
        myList.add(new NamePhone("name02", "phone02"));
        myList.add(new NamePhone("name03", "phone03"));
        myList.add(new NamePhone("name04", "phone04"));
        myList.add(new NamePhone("name05", "phone05"));
        Set<NamePhone> newSet = myList.stream().collect(
            () -> new HashSet<NamePhone>(),
            HashSet::add,
            HashSet::addAll
        );
        for (NamePhone np : newSet) {
            System.out.println(np.name + "  " + np.phone);
        }
    }
}
