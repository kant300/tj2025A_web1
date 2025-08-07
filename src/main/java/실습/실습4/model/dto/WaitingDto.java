package 실습.실습4.model.dto;

import lombok.*; // 롬복 : 설계에서 자주 사용되는 코드를 자동생성ㅊ

@NoArgsConstructor // 빈생성자 자동생성
@AllArgsConstructor // 전체 생성자 자동생성
@Getter // 모든 멤버변수에 대해서 getter 메소드
@Setter // 모든 멤버변수에 대해서 setter 메소드 * 생략시 VO(읽기모드)
@ToString // 객체조회시 주소값 대신에 모든 멤버변수를 문자열 출력 메소드
public class WaitingDto {
    // 멤버변수
    private int wno; // 대기번호
    private String phone; // 연락처
    private int count; // 인원수
    private String wdate; // 등록일
}
