package sisoftTestTask.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


@Service
public class HTMLDownloader {

    static final Logger logger = LoggerFactory.getLogger(HTMLDownloader.class);
    public String url;
    public File download() throws IOException {

        File tmpFile = File.createTempFile("file", null);
        BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите адрес HTML-страницы для подсчета количества слов:");
        while (tmpFile.length() == 0) {
            try {
                url = bufReader.readLine();
                downloadUsingStream(url, tmpFile);
            } catch (Exception e) {
                System.out.println("Некорректный URL! Пожалуйста введите корректный адрес файла:");
                logger.error("Incorrect url!");
            }
        }
        bufReader.close();
        return tmpFile;
       }

    private void downloadUsingStream(String urlStr, File file) throws MalformedURLException {
        URL url = new URL(urlStr);
        try (BufferedInputStream bis = new BufferedInputStream(url.openStream());
             FileOutputStream fis = new FileOutputStream(file))
        {
            byte[] buffer = new byte[1024];
            int count = 0;
            while((count = bis.read(buffer,0,1024)) != -1)
            {
                fis.write(buffer, 0, count);
            }
        } catch (Exception e) {
            logger.error("Error while streamDownloading!");
        }
    }

}
