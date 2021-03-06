package sisoftTestTask.util;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrintWords {

    public static void print(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue());
        for (Map.Entry<String, Integer> pair : list) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
