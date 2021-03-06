package sisoftTestTask.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sisoftTestTask.model.WordItem;
import sisoftTestTask.repository.WordRepository;

import java.util.Map;

@Service
public class ExportWords {

    static final Logger logger = LoggerFactory.getLogger(ExportWords.class);

    @Autowired
    private WordRepository wordRepository;

    // Exporting results to DataBase (using JPA repository).
    public void export(Map<String, Integer> map, String address){
        System.out.println("Saving results to DB...");
        try {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                WordItem item = new WordItem(entry.getKey(), entry.getValue(), address);
                this.wordRepository.save(item);
            }
        } catch (Exception e) {
            logger.error("DB connection Error!");
            System.out.println("DB connection Error!");
            System.exit(1);
        }
        System.out.println("Count results for " + address + " exported to Database");
        System.exit(1);
    }

}
