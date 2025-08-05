package 종합.예제11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        // view 실행하는게 아닌 스프링( 부트포함 + @SpringBootApplication) 실행
        // + 스프링 실행하면 프로젝트내 rosource 폴더의 static 폴더 HTML/CSS/JS 프로튼엔드 싹다 등록한다.
        SpringApplication.run( AppStart.class );
    }//main e
}//class e
