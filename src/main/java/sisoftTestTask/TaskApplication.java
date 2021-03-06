package sisoftTestTask;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import sisoftTestTask.service.HTMLCounter;
import javax.annotation.PostConstruct;


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

    //Starting Spring-Boot application. Calling for word-counter service
    public static void main(String[] args) {
        new SpringApplicationBuilder(TaskApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        statTask.htmlCounter.countHtmlWords();
    }

}
