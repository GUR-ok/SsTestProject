package sisoftTestTask.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sisoftTestTask.util.ExportWords;
import sisoftTestTask.util.PrintWords;
import sisoftTestTask.util.SaveWords;

import java.io.*;
import java.util.Map;

@Service
public class HTMLCounter {

    static final Logger logger = LoggerFactory.getLogger(HTMLCounter.class);
    @Autowired
    HTMLDownloader downloader;
    @Autowired
    FileParser parser;
    @Autowired
    WordCounter counter;

    String address;

    public HTMLCounter() {
    }

    public void countHtmlWords() {
        File file = null;
        try {
            file = downloader.download();
            address = downloader.url;
            String parsedText = parser.parse(file);
            System.out.printf("Body: %s", parsedText);
            Map<String, Integer> map = counter.countWords(parsedText);
            PrintWords.print(map);
            SaveWords.save(map, address);
            ExportWords.export(map, address);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File download/parse error!");
        }

    }

}

