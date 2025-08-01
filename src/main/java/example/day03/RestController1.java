package example.day03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    // ++++++++++++매개변수++++++++++++++
    // 메소드에서 매개변수란 ? 메소드 호출시 메소드 안으로 들어오는 값을 저장하는 변수
    // + HTTP 요청시에도 인자/자원 보낼수 있다.
    //
    @GetMapping("/day03/param1")
    public boolean method2( @RequestParam (name = "name" , defaultValue = "홍길동" , required = true ) String name ){
        // @RequestParam : Request(요청) + Param(매개변수) 요청매개변수 매핑 어노테이션
        // + @RequsetParam(  name = "URL매개변수명" , defaultValue = "초기값" , required = true/false );
        // ++ name = "URL매개변수명" : 주소(URL)상의 ? 뒤로 매핑(연결) 할 매개변수명 명시, 단 자바매개변수와 이름이 동일시 생략가능
            // 예] http://localhost:8080/day03/param1?name=유재석 -----> String name
            // 예] http://localhost:8080/day03/param1?name=유재석 -----> @RequsetParam ( name = "name" ) String nickName
        // ++ defaultValue = "홍길동" : 만약에 매개변수명에 값이 생략되면 자동으로 들어가는 값
            // 예] http://localhost:8080/day03/param1?name=유재석 ----> "유재석'
            // 예] http://localhost:8080/day03/param1            ----> "홍길동"
        // ++ required : 만약에 해당 매개변수가 없으면 예외(자동)발생 ,
        // 예] http://localhost:8080/day03/param1?name=유재석 ----> 정상
            // 예] http://localhost:8080/day03/param1        ----> 400 ERROR
        System.out.println("RestController1.method2"); //soutm 현재 메소드명 출력
        System.out.println("name = " + name); // soutp 현재 메소드 매개변수 출력
        return true;
    }

    @GetMapping("/day03/param2")
    // http://localhost:8080/day03/param2?name=강호동&age=20
    public int method3( @RequestParam( required = true ) String name ,
                        @RequestParam( name = "age") int 나이 ){ // *자동타입 변환*
        // 통신확인방법 : soutm , soutp
        System.out.println("RestController1.method3");
        System.out.println("name = " + name + ", age = " + 나이 );
        return 3; // 임의 값 반환
    }

    @DeleteMapping("/day03/param3")
    public String method4( @RequestParam Map<String , String> map ){
        // 일반적으로 정해진 규칙이나 매개변수명이 아닌 단순 MAP (비규칙) 구조
        System.out.println("RestController1.method4");
        // MAP :KEY와 VALUE 를 한쌍(ENTRY) 구성하여 여러개 ENTRY 저장 구조
        System.out.println("map = " + map);
        return "안녕"; //임의값
    }





    @DeleteMapping("/day03/param4")
    // http://localhost:8080/day03/param4?name=유재석&age=40
    // ++ DTO 에 자동 매핑하기 위해서는 DTO에도 name과 age멤버변수가 존재해야 한다. +생성자+setter
    public int method5( @RequestParam TaskDto taskDto ){
        // @RequestParam : DTO내 동일한 멤버변수와 생성자가 구성된 상태일때
        // new TaskDto() 생략해도 자동으로 생성된다.
        System.out.println("RestController1.method5");
        System.out.println("taskDto = " + taskDto);
        return 3;
    }
    /*
    *쿼리스트링이랑 ? URL?매개변수=값&매개변수=값
                 @RequestParam              vs      @ModelAttribute
     역할       단일 파라미터에 변수 바인딩               복수 파라미터에 객체 바인딩
     생략기준   변수명이 일치할 경우(쿼리스틸의 매개변수)    DTO타입일때 기본적용(+생성자,+Setter)
     주요타입   기본형: int/String/Map/List            DTO/VO(개발자가만든객체) *VO(읽기모드)

     */





}// class e



