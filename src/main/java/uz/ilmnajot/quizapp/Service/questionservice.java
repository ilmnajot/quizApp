package uz.ilmnajot.quizapp.Service;

import com.example.quiz_app.DTO.DeleteResponseDto;
import com.example.quiz_app.DTO.ResponseDto;
import com.example.quiz_app.Entity.Question;
import com.example.quiz_app.Repostory.questionrepostory;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor

public class questionservice {

    private questionrepostory repo;


    public ResponseEntity<ResponseDto> getAllQuiz() {
        try {
            List<Question> quizes = repo.findAll();
            if (quizes.isEmpty()) {
                ResponseDto response = new ResponseDto("no quiz found", quizes);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                ResponseDto response = new ResponseDto("quiz found", quizes);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            ResponseDto response = new ResponseDto("unexpected error", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    public ResponseEntity<ResponseDto> getAllByCatogery(String cat) {
        try {
            List<Question> quizes = repo.findByquizCatogery(cat);
            if (quizes.isEmpty()) {
                ResponseDto response = new ResponseDto("no quiz found", quizes);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            } else {
                ResponseDto response = new ResponseDto("quiz found", quizes);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            }
        } catch (Exception e) {
            ResponseDto response = new ResponseDto("unexpected error", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    public ResponseEntity<ResponseDto> saveQuiz(Question quiz) {
        try {
            if (repo.existsById(quiz.getQuizId())) {
                ResponseDto response = new ResponseDto("quiz already exists", null);
                return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(response);
            } else {
                repo.save(quiz);
                ResponseDto response = new ResponseDto("quiz is saved", null);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
            }


        } catch (Exception e) {
            ResponseDto response = new ResponseDto("unexpected error", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }

    }

    public ResponseEntity<ResponseDto> updateQuiz(Question question) {
        try {
            if (repo.existsById(question.getQuizId())) {
                repo.save(question);
                ResponseDto response = new ResponseDto("question is updated", null);
                return ResponseEntity.status(HttpStatus.OK).body(response);
            } else {
                ResponseDto response = new ResponseDto("question is not updated:check qusetion details and try agin", null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            ResponseDto response = new ResponseDto("unexpected error " + e, null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    public String deleteQuiz(Question question) {
        try {
            if (repo.existsById(question.getQuizId())) {
                repo.delete(question);
                // deleteresponseDto response=new  deleteresponseDto("question is deleted",null);
                // return ResponseEntity.status(HttpStatus.OK).body(response);
                return "delete sucssus";
            } else {
                DeleteResponseDto response = new DeleteResponseDto("question is not deleted", null);
                //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                return "delete not sucssus";
            }
        } catch (Exception e) {
            DeleteResponseDto response = new DeleteResponseDto("unexpected error" + e, null);
            // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            return "reeor";
        }
    }
}


