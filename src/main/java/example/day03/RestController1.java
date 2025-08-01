package example.day03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// AppStart : 스프링 실행과 동시에 같은 패키지/하위패키지내 모든 컴포넌트 스캔 자동 빈(객체) 등록


// @Controller // 스프링에게 해당 클래스는 Controller 입니다. 알림
// 어노테이션이란 ? (라벨) 택배상자안에 있는 실질적은 내용물이 아닌, 택배상자 앞에 붙인 '유리취급주의'부착
// + HTTP(웹통신) 지원 + @Component 포함( @SpringBootApplication 가 스캔하는 대상 )
@org.springframework.web.bind.annotation.RestController
public class RestController1{
    // 싱글톤 생략 : @Component 사용했기 때문에
    @GetMapping("/day03") // HTTP(웹통신 규약) 지원하고 그중에서 'GET" METHOD 사용, baseURL뒤로 자원URL 정의
    // url : http://localhost:8080/day03
    // Whilelable Error Page : 요청은 정상이지만, 응답은 없다.
    @ResponseBody //
    public String method1(){
        return "자바에서 보내온 메시지";

    }
}

