package example.day01;

import example.day01.controller.BoardController;
import example.day01.model.dto.BoardDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class AppStart {
    public static void main(String[] args) {
        System.out.println("자바실행");

        // BoardService 10 : view 제외한 동일한 구조
        // 1. 20250723 등록 테스트
        boolean result = BoardController.getInstance().boardWrite("테스트내용","강사");
        System.out.println( result );

        // 2. 20250723 전체조회 테스트
        ArrayList<BoardDto> result2 = BoardController.getInstance().boardPrint();
        System.out.println( result2 );

        SpringApplication.run( AppStart.class );

    } // main end
} // class end
