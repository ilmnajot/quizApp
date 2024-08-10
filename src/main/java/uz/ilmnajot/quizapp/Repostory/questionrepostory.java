package uz.ilmnajot.quizapp.Repostory;

import com.example.quiz_app.Entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface questionrepostory extends JpaRepository<Question,Integer> {
        public List<Question> findByquizCatogery(String cat);
    @Query(value = "SELECT * FROM question  WHERE quiz_catogery=:cat ORDER BY RAND() LIMIT :numQ" ,nativeQuery = true)
    public List<Question> findRandomQuizByCatogery(String cat, int numQ);



}
