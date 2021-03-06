package sisoftTestTask.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class FileParser {

    static final Logger logger = LoggerFactory.getLogger(FileParser.class);

    //Parsing words from HTML content file. Method uses Jsoup HTML parser, returns text from HTML as String
    public static String parse(File file) throws IOException {
        Document document = Jsoup.parse(file, "UTF-8");
        logger.warn("File parsed successfully!");
        String title = document.title();
        String body = document.body().text();
        System.out.println();
        System.out.printf("Title: %s%n", title);
        return body;
    }

}
