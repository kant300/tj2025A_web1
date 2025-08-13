package example.day10;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController // HTTP 통신 컨트롤러
@RequestMapping("/day10") // 공통 URL
public class LoginController {

    // 1. 로그인 : 아이디와 패스워드가 일치하면 *세션*에 로그인 성공한 회원번호 저장
    // ex] console 프로젝트에서는 : static int loginMno
    //
    @PostMapping("/login") // 패스워드 중요 데이터가 있으므로 queryString 보다 body 사용
    public boolean login(@RequestBody LoginDto loginDto , HttpServletRequest request ){
        // HttpServletRequest :
        System.out.println( request.getRemoteAddr() ); // 통신을 요청한 클라이언트(사용자)의 IP확인
        System.out.println( request.getRemotePort() ); // 통신을 요청한 클라이언트(사용자)의 PORT 확인
        System.out.println( request.getHeader("User-Agent") ); // 통신을 요청한 클라이언트(사용자)의 브라우저정보 확인, HTTP Head
        // **** 세션 정보 가져오기 , 세션이란? 톰캣 서버내 저장소( key-value / MAP 컬렉션 사용 )
        HttpSession session = request.getSession();
        System.out.println( session.getId() ); //세션의 식별번호 : 브라우저마다, pc마다 다르게 할당 된다.
        System.out.println( session.getCreationTime() ); // 세션의 생성시간(ms) : 최초 요청한 시간
        System.out.println( session.getLastAccessedTime() ); // 세션의 마지막 접근시간(ms) , ms(밀리초=1/1000초)
        System.out.println( session.getMaxInactiveInterval() ); // 세션의 최대 유효시간(초)
        // **** 세션 속성 추가하기 , 속성이란? 키와 값으로 구성된 메모리 공간
        session.setAttribute("loginMno" , 3 ); // .setAttribute("속성명" , 속성값);
        // loginMno 라는 속성명으로 3이라는 데이터 저장하겠다는 뜻
        return true;

    }
    // 2. 로그인된 정보 확인 : 현재 세션에 저장된 회원정보 확인
    @GetMapping("/info")
    public boolean info( HttpServletRequest request ){
        //
        HttpSession session = request.getSession();
        //
        Object obj = session.getAttribute("loginMno");
        //
        int loginMno = (int)obj; // 서버톰캣(스프링)를 재시작하면 모든 세션정보는 초기화
        System.out.println( loginMno );

        return true;

    }

}
