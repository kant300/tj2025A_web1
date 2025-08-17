package 과정평가.자격.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter@Setter@ToString
public class MemberDto { // 회원정보
    private int custno;         // 회원번호
    private String custname;    // 회원성명
    private String phone;       // 연락처
    private String address;     // 주소
    private String joindate;    // 가입일자
    private String grade;       // 고객등급
    private String  city;        // 거주도시 코드

}
