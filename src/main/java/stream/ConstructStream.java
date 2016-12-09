package stream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author: huyuanzhi
 * @version: 1.0
 * @date: 2016/12/8
 * @project: leaderlearing
 * @packageName: stream
 * @description: XXXXXX
 */
public class ConstructStream {

    //解除层级关系,融合到一起
    private static void flatMap() {
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        inputStream.flatMap((childList) -> childList.stream()).forEach(System.out::print);
    }

    //map 生成的是个 1:1 映射，每个输入元素，都按照规则转换成为另外一个元素
    private static void map() {
        List<Integer> list = Arrays.asList(4, 8, 3, 6, 5, 8, 7, 1, 3);
        list.stream().map(n -> n * n).collect(Collectors.toList()).forEach(System.out::print);
    }

    private static void range() {
        IntStream.range(1, 3).forEach(System.out::print);//输出12不包括3
        IntStream.rangeClosed(1, 3).forEach(System.out::print);//输出123包括3
    }

    private static void filter() {
        Integer[] array = new Integer[]{1, 8, 3, 7, 15, 56, 13, 11};
        Integer[] newArray = Arrays.stream(array).filter(t -> t % 2 == 0).toArray(Integer[]::new);
        Arrays.stream(newArray).forEach(System.out::print);
    }

    private static void filterAndFlatMap() throws Exception {
        try (BufferedReader reader = new BufferedReader(new FileReader("d://q3.dat"))) {
            List words = reader.lines().flatMap(lineWord -> Stream.of(lineWord.split("\n"))).filter(word -> word.length() > 0).collect(Collectors.toList());
            words.stream().forEach(System.out::print);
        }
    }

    private static void peek() {
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());
    }

    private static void reduce() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ints sum is:" + ints.stream().reduce(0, (sum, item) -> sum + item));
        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());


        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce(String::concat).get();
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 5).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        System.out.println(sumValue);
    }

    private static void findFirst() {
        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(ints.stream().findAny().get());
    }

    public static void main(String[] args) throws Exception {
        reduce();
    }
}
