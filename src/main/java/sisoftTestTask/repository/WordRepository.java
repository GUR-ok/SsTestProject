package sisoftTestTask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sisoftTestTask.model.WordItem;

@Repository
public interface WordRepository extends JpaRepository<WordItem, Integer> {
}
