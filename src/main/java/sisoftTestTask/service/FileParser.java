package sisoftTestTask.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class FileParser {

    static final Logger logger = LoggerFactory.getLogger(FileParser.class);

    public String parse(File file) throws IOException {

        Document document = Jsoup.parse(file, "UTF-8");
        logger.warn("File parsed successfully!");
        String title = document.title();
        String body = document.body().text();
        System.out.println();
        System.out.printf("Title: %s%n", title);
        return body;
    }

}
