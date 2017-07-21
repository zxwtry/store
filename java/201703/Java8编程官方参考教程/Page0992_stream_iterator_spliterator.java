import java.util.*;
import java.util.stream.*;

public class Page0992_stream_iterator_spliterator {
    public static void main(String[] args) {
        //integerIterator();
        //integerSpliterator();
        //integerSpliterator2();
        integerSpliteratorTrySplit();
    }
    public static void integerIterator() {
        List<Integer> myList = Arrays.asList(99, 105, 23, 11, 88);
        Iterator<Integer> iter = myList.stream().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
    public static void integerSpliterator() {
        List<Integer> myList = Arrays.asList(99, 105, 23, 11, 88);
        Spliterator<Integer> spliter = myList.stream().spliterator();
        while(spliter.tryAdvance((n) -> System.out.println(n)));
    }
    public static void integerSpliterator2() {
        List<Integer> myList = Arrays.asList(99, 105, 23, 11, 88);
        Spliterator<Integer> spliter = myList.stream().spliterator();
        spliter.forEachRemaining((n) -> System.out.println(n));
    }
    public static void integerSpliteratorTrySplit() {
        List<Integer> myList = Arrays.asList(99, 105, 23, 11, 88);
        Spliterator<Integer> spliter = myList.stream().spliterator();
        Spliterator<Integer> spliter1 = spliter.trySplit();
        System.out.println("spliter1 start : ");
        spliter1.forEachRemaining((n) -> System.out.println(n));
        System.out.println("spliter start : ");
        spliter.forEachRemaining((n) -> System.out.println(n));
    }
}
