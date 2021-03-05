package sisoftTestTask.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PrintWords {
    static final Logger logger = LoggerFactory.getLogger(PrintWords.class);

    public static void print(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue());
        for (Map.Entry<String, Integer> pair : list) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
