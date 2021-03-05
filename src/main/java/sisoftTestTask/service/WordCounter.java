package sisoftTestTask.service;

import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

@Service
public class WordCounter {

    private static final String DELIMITER = "[ ,.!?\'\";:()\n\r\t\\[\\]]";

    public Map<String, Integer> countWords(String str) {
        String[] words = str.split(DELIMITER);

        Map<String, Integer> counts = new TreeMap<>();
        for(String word : words){
            if (word.length() > 0)
            {
                word = word.toUpperCase(Locale.ROOT);
                if (!counts.containsKey(word)) {
                    counts.put(word, 1);
                } else
                    counts.put(word, counts.get(word) + 1);
            }
        }
        return counts;
    }

}
