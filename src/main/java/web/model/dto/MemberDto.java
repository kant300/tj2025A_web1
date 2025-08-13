package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor
@Data
public class MemberDto {
    // 멤버변수 : 기본적으로 데이터베이스 테이블과 일치하게 하되, 상황에 따라 커스텀 해야 한다.
    private  int mno;
    private String mid;
    private String mpwd;
    private String mname;
    private String mphone;
    private String mdate; //datetime은 다양한 타입이 존재하지만 편하게 문자타입으로 사용
}
