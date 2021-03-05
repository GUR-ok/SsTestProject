package sisoftTestTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sisoftTestTask.service.HTMLCounter;
import javax.annotation.PostConstruct;
import java.io.*;


@SpringBootApplication
public class TaskApplication {

    @Autowired
    public HTMLCounter htmlCounter;

    private static TaskApplication statTask;
    @Autowired
    private TaskApplication task;

    @PostConstruct
    public void init() {
        TaskApplication.statTask = task;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(TaskApplication.class, args);
        statTask.htmlCounter.countHtmlWords();
    }
}
