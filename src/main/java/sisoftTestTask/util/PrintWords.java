package sisoftTestTask.util;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class PrintWords {

    //Printing Map of words and counted values into Console
    public static void print(Map<String, Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.<String, Integer>comparingByValue());
        for (Map.Entry<String, Integer> pair : list) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
