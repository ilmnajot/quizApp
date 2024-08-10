package uz.ilmnajot.quizapp.DTO;

import com.example.quiz_app.Entity.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDto {


    private String massage;


    private List<Question> body;

}
