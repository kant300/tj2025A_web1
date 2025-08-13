package example.day10;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data // @setter and @getter, @toString 3개 어노테이션 포함
public class LoginDto {
    private int mno;    //회원번호
    private String mid; //회원아이디
    private String mpw; //회원비밀번호
}
