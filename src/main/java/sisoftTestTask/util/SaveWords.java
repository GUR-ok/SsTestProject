package sisoftTestTask.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class SaveWords {
    static final Logger logger = LoggerFactory.getLogger(SaveWords.class);

    public static void save(Map<String, Integer> map, String address) {
        String RESULT_PATH = "results\\";
        File toSave = new File(RESULT_PATH+ UUID.randomUUID().toString() + ".txt");
        toSave.getParentFile().mkdirs();

        try (FileWriter writer = new FileWriter(toSave)){
            writer.write("Count results for " + address + "\n");
            for (Map.Entry<String, Integer> entry : map.entrySet()){
                writer.write(entry.getKey() + " - " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            logger.error("Error during saving for results");
            System.exit(1);
        }

        System.out.println("Count results for " + address + " saved to " + toSave.getAbsolutePath());
    }

}
