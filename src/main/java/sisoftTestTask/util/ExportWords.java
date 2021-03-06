package sisoftTestTask.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sisoftTestTask.model.WordItem;
import sisoftTestTask.repository.WordRepository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
public class ExportWords {
    static final Logger logger = LoggerFactory.getLogger(ExportWords.class);

    @Autowired
    private WordRepository wordRepository;

    private static ExportWords exportWords;
    @Autowired
    private ExportWords exp;
    @PostConstruct
    public void init() {
        ExportWords.exportWords = exp;
    }

    public static void export(Map<String, Integer> map, String address){
        System.out.println("Saving results to DB...");
        try {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                WordItem item = new WordItem(entry.getKey(), entry.getValue(), address);
                exportWords.wordRepository.saveAndFlush(item);
            }
        } catch (Exception e) {
            logger.error("DB communication Error!");
            System.out.println("DB communication Error!");
            System.exit(1);
        }
        System.out.println("Count results for " + address + " exported to Database");
        System.exit(1);
    }
}
