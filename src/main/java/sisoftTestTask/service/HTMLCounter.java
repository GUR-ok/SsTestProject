package sisoftTestTask.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sisoftTestTask.util.*;

import java.io.*;
import java.util.Map;

@Service
public class HTMLCounter {

    static final Logger logger = LoggerFactory.getLogger(HTMLCounter.class);

    @Autowired
    Downloader downloader;

    @Autowired
    WordCounter counter;

    @Autowired
    ExportWords exportWords;

    String address;

    /* Main service provides:
    * - downloading HTML-page to temp file;
    * - parsing words from HTML-content;
    * - counting unique words;
    * - printing words to console;
    * - saving results to file;
    * - exporting results to DataBase;
    * - logging errors.
    */
    public void countHtmlWords() {
        File file = null;
        try {
            file = downloader.download();
            address = downloader.url;
            String parsedText = FileParser.parse(file);
            Map<String, Integer> map = counter.countWords(parsedText);
            PrintWords.print(map);
            SaveWords.save(map, address);
            exportWords.export(map, address);
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("File download/parse error!");
        }
    }

}

