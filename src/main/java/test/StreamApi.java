package test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static java.util.stream.Collectors.*;

/**
 * Created by Administrator on 2016/12/8 0008.
 */
public class StreamApi {
    static Function<String, String> prefix = s -> {
        String ret = s.substring(0, 3);
        return ret;
    };


    static Function<String, Long[]> toInfo = s -> {
        Long[] ret = new Long[2];
        String[] items = s.split(",");
        ret[0] = Long.valueOf(items[1]);
        ret[1] = Long.valueOf(items[2]);
        return ret;
    };

    static BinaryOperator<Long[]> toSat = (longs, longs2) -> {
        Long[] ret = new Long[]{0L, 0L};
        ret[0] = longs[0] + 13 * longs2[0] + longs2[1];
        ret[1] = longs[1] + 1;
        return ret;
    };

    static Comparator<Map.Entry<String, Long[]>> cmp = (o1, o2) -> Long.compare(o2.getValue()[0], o1.getValue()[0]);

    static Long[] init = new Long[]{0L, 0L};
    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        try {
            Files.lines(Paths.get("d://q3.dat"), StandardCharsets.UTF_8)
                    .collect(groupingByConcurrent(prefix,
                            mapping(toInfo, reducing(init,
                                    toSat))))
                    .entrySet()
                    .stream()
                    .sorted(cmp)
                    .limit(10L)
                    .forEach(
                            (Map.Entry<String, Long[]> entry)->{
                                System.out.printf("%s,%d,%d\n", entry.getKey(),
                                        entry.getValue()[0],
                                        entry.getValue()[1]);
                            }
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - t0);
    }
}
