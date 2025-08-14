package web.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor@AllArgsConstructor
@Data
public class SocialMemberDto {
    private String socialType; // 예: "google", "naver", "kakao"
    private String socialId;   // 소셜 서비스에서 발급받은 고유 ID
    private String mname;      // 소셜 서비스에서 가져온 이름
    private String mphone;  // 소셜 서비스에서 가져온 휴대폰 번호 (없을 수도 있음)
    private String email;   // 소셜 서비스에서 가져온 이메일
    // 필요한 경우, 우리 서비스의 회원가입시 추가정보를 받을 필드를 포함할 수있습니다.
}
