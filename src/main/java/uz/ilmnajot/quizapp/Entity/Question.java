package uz.ilmnajot.quizapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {

    @Id
    private Integer quizId;
    private String quizTitle;
    private String quizCategory;
    private String quizLevel;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String rightAnswer;


}
