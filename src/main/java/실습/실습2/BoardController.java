package 실습.실습2;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BoardController {

// 게시물 등록
@PostMapping("/board") //http://localhost:8080/board?bcontent=안녕하세요&bwriter=유재석
public boolean boardWrite( @RequestBody BoardDto boardDto ){
    System.out.println("BoardController.boardWrite");
    System.out.println("boardDto = " + boardDto);
    return true;
}
// 게시물 전체조회
@GetMapping("/board")
public List<BoardDto> boardPrint(){
    System.out.println("BoardController.boardPrint");
    ArrayList<BoardDto> list = new ArrayList<>();
    list.add( new BoardDto( 1, "안녕하세요" , "유재석" ) );
    list.add( new BoardDto( 2, "안녕하세요2" , "강호동" ) );
    return list;
}
// 게시물 개별조회
@GetMapping("/board/detail")//http://localhost:8080/board/detail?bno=1
public BoardDto boardDetail( @RequestParam int bno){
    System.out.println("BoardController.boardPrint");
    ArrayList<BoardDto> boardDto= new ArrayList<>();
    boardDto.add( new BoardDto( 1, "안녕하세요" , "유재석" ) );
    boardDto.add( new BoardDto( 2, "안녕하세요2" , "강호동" ) );
    return boardDto.get(1);
    }

// 게시물 삭제
@DeleteMapping("/board") //http://localhost:8080/board?bno=1
public boolean boardDelete(@RequestParam int bno ) {
    ArrayList<BoardDto> boardDto= new ArrayList<>();
    boardDto.add( new BoardDto( 1, "안녕하세요" , "유재석" ) );
    boardDto.add( new BoardDto( 2, "안녕하세요2" , "강호동" ) );
    return true;
}

// 게시물 수정
@PutMapping("/board") // put // 바디에 객체를 입력
public boolean boardUpdate(@RequestBody BoardDto boardDto ){
    System.out.println("BoardController.boardUpdate");
    System.out.println("boardDto = " + boardDto);
    return false;

}


}// class e
