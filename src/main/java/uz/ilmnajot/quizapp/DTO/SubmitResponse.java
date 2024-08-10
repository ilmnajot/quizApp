package uz.ilmnajot.quizapp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SubmitResponse {

    private Integer quizId;
    private String response;

}
