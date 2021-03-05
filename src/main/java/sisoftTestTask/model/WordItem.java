package sisoftTestTask.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WordItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String word;
    int count;
    String link;

    public WordItem() {
    }

    public WordItem(String word, int count, String link) {
        this.word = word;
        this.count = count;
        this.link = link;
    }
}
