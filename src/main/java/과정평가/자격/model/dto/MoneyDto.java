package 과정평가.자격.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class MoneyDto { // 회원매출정보
    private int custno;     // 회원번호
    private int salenol;    // 매출번호
    private int pcost;      // 단가
    private int amount;     // 수량
    private int price;      // 가격(금액)
    private String pcode;   // 상품코드
    private String date;    // 판매일자
}
