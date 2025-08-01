package example.day03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // 스프링 기본 세팅 + 컴포넌트(싱글톤 대용) 스캔 + 내장 톰캣(서버) 실행
public class Appstart {
    public static void main(String[] args) {
        SpringApplication.run( Appstart.class ); //
    }//main e
}// class e
