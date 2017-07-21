import java.util.*;
import java.util.stream.*;

public class Page0974_Collection_stream_parallelStream {
    public static void main(String[] args) {
        Collection<Integer> coll = new ArrayList<Integer>();
        coll.add(4);
        coll.add(3);
        coll.add(1);
        coll.add(0);
        Stream<Integer> collStream = coll.stream();
        Stream<Integer> collParallelStream = coll.parallelStream();
        //System.out.println("coll stream count is : " + collStream.count());
        System.out.println("coll parallel stream count is : " + collParallelStream.count());
        Object[] arr = collStream.toArray();
        Integer[] newArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i ++) {
            newArr[i] = (Integer)arr[i];
        }
        Stream<Integer> arrStream = Arrays.stream(newArr);
        System.out.println("arr stream count is : " + arrStream.count());
    }

}


