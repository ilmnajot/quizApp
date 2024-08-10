package uz.ilmnajot.quizapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.ilmnajot.quizapp.Entity.Question;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteResponseDto {

    private String massage;
    private Optional<Question> question;
}
