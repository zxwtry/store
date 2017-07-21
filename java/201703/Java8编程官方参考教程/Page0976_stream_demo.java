import java.util.*;
import java.util.stream.*;

public class Page0976_stream_demo {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(67, 69, 1, 2, 8);
        //basicStream(myList);
        //maxVal(myList);
        //minVal(myList);
        //sortedStream(myList);
        //oddVals(myList);
        //multiMiddleOperation(myList);
        //reduceOptional(myList);
        //reduceAnswer(myList);
        //evenProductOptional(myList);
        //evenProduct(myList);
        //parallelAdd(myList);
        //parallelAdd2(myList);
        //parallelSqrtRootMulti(myList);
        //parallelSqrtRootMulti2(myList);
        parallelSqrtRootMultiWrong(myList);
    }
    static void basicStream(List<Integer> myList) {
        Stream<Integer> myStream = myList.stream();
        myStream.forEach((n) -> System.out.println(n));
    }
    static void maxVal(List<Integer> myList) {
        Optional<Integer> maxV = myList.stream().max(Integer::compare);
        if (maxV.isPresent()) {
            System.out.println(maxV.get());
        }
    }
    static void minVal(List<Integer> myList) {
        Optional<Integer> minV = myList.stream().min(Integer::compare);
        if (minV.isPresent()) {
            System.out.println(minV.get());
        }
    }
    static void sortedStream(List<Integer> myList) {
        Stream<Integer> sortedStream = myList.stream().sorted();
        sortedStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
    static void oddVals(List<Integer> myList) {
        Stream<Integer> oddVals = myList.stream().filter((n) -> n % 2 == 1);
        oddVals.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
    static void multiMiddleOperation(List<Integer> myList) {
        Stream<Integer> multi = myList.stream().filter((n) -> n % 2 == 1).sorted().filter((n) -> n % 4 == 1);
        multi.forEach((n) -> System.out.print(n + " "));
        System.out.println();
    }
    static void reduceOptional(List<Integer> myList) {
        Optional<Integer> productObj = myList.stream().reduce((a, b) -> a * b);
        if (productObj.isPresent()) {
            System.out.println(productObj.get());
        }
    }
    static void reduceAnswer(List<Integer> myList) {
        Integer product = myList.stream().reduce(1, (a, b) -> a * b);
        System.out.println(product);
    }
    static void evenProductOptional(List<Integer> myList) {
        //这里得到的结果和evenProduct不一样
        //得到的结果是67 * 2 * 8
        //原因未知
        Optional<Integer> evenProductAnswer = myList.stream().reduce(
            (a, b) -> (b % 2 == 1) ? a : a * b
        );
        if (evenProductAnswer.isPresent()) {
            System.out.println(evenProductAnswer.get());
        }
    }
    static void evenProduct(List<Integer> myList) {
        Integer evenProductAnswer = myList.stream().reduce(
            1,
            (a, b) -> (b % 2 == 1) ? a : a * b 
        );
        System.out.println(evenProductAnswer);
    }
    static void parallelAdd(List<Integer> myList) {
        Stream<Integer> myStream = myList.parallelStream();
        Double val = myStream.reduce(
            1.0,
            (a, b) -> a * Math.sqrt(b),
            (a, b) -> a + b
        );
        System.out.println(val);
    }
    static void parallelAdd2(List<Integer> myList) {
        Stream<Integer> myStream = myList.parallelStream();
        Integer val = myStream.reduce(
            1,
//            (a, b) -> a * Math.sqrt(b),
            (a, b) -> a + b
        );
        System.out.println(val);
    }
    static void parallelSqrtRootMulti(List<Integer> myList) {
        Stream<Integer> mySequentialStream = myList.stream();
        Stream<Integer> myParallelStream = mySequentialStream.parallel();
        Double val = myParallelStream.reduce(
            1.0,
            (a, b) -> a * Math.sqrt(b),
            (a, b) -> a * b
        );
        System.out.println(val);
    }
    static void parallelSqrtRootMulti2(List<Integer> myList) {
        Stream<Integer> myParallelStream = myList.parallelStream();
        Stream<Integer> mySequentialStream = myParallelStream.sequential();
        Integer val = mySequentialStream.reduce(
            1,
            (a, b) -> a * (int)Math.sqrt(b)
//            (a, b) -> a * b
        );
        System.out.println(val);
    }
    static void parallelSqrtRootMultiWrong(List<Integer> myList) {
        Stream<Integer> mySequentialStream = myList.stream();
        Stream<Integer> myParallelStream = mySequentialStream.parallel();
        Integer val = myParallelStream.reduce(
            1,
            (a, b) -> a * (int)Math.sqrt(b)
        );
        System.out.println(val);
    }
}
