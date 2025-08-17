package 과정평가.자격.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class TotalMoneyDto { // 총매출액 조회
    private int custno;     // 회원번호
    private String custname;    // 회원성명
    private String grade;       // 고객등급
    private int totalSales;     // 매출액

}
