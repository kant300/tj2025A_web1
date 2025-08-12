package 과정평가.자격.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class TotalMoneyDto {
    private int custno;
    private String custname;
    private String grade;
    private int totalPrice;

}
