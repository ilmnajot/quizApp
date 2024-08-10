package uz.ilmnajot.quizapp.Controller;

import com.example.quiz_app.DTO.ResponseDto;
import com.example.quiz_app.Entity.Question;
import com.example.quiz_app.Service.questionservice;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
@AllArgsConstructor
public class Question_controller {

    private questionservice service;

    @GetMapping("/getQuestions")
    public ResponseEntity<ResponseDto> getAllQuiz() {
        return service.getAllQuiz();
    }
    @GetMapping("/getQuizByCategory/{cat}")
    public ResponseEntity<ResponseDto> getAllByCategory(@PathVariable String cat) {
        return service.getAllByCatogery(cat);
    }

    @PostMapping("/addquizes")
    public ResponseEntity<ResponseDto> saveQuiz(@RequestBody Question quiz){
        return service.saveQuiz(quiz);
    }

    @PutMapping("/updateQuiz")
    public ResponseEntity<ResponseDto> updateQuiz(@RequestBody Question question){
       return service.updateQuiz(question);
    }

    @DeleteMapping("/deletequiz")
    public String deleteQuiz(@RequestBody Question question){

        return service.deleteQuiz(question);
    }

}
