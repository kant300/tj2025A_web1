package 실습.실습1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController {
    // 1)  글쓰기          등록 : CREATE -> @PostMapping
    @PostMapping ("/exam1/board")       // Talend API : [METHOD] POST , [Scheme] : http://localhost/exam1/board ,
    @ResponseBody
    public boolean 글쓰기() {
        System.out.println("BoardController.글쓰기");
        return true;
    } // m end
    // 2) 전체 글조회 : READ -> @GetMapping
    @GetMapping("/exam1/board")         // Talend API : [METHOD] GET , [Scheme] : http://localhost/exam1/board
    @ResponseBody
    public List<BoardDto> 전체조회(){
        System.out.println("BoardController.전체조회");
        ArrayList<BoardDto> list = new ArrayList<>(); // 임의데이터
        list.add( new BoardDto( 1, "제목1") );
        list.add( new BoardDto( 2 , "제목2") );
        list.add( new BoardDto( 3 , "제목3") );
        return list;
    } // m end
    // 3) 개별 글 조회 : READ -> @GetMapping
    @GetMapping("/exam1/board/view")     // Talend API : [METHOD] GET , [Scheme] : http://localhost/exam1/board/view
    @ResponseBody
    public Map< Integer , String > 개별조회(){
        System.out.println("BoardController.개별조회");
        Map<Integer , String> map = new HashMap<>();
        map.put( 2, "제목2");
        return map;
    }

    // 4) 개별 글 수정 : UPDATE -> @PutMapping
    @PutMapping("/exam1/board")         // Talend API : [METHOD] PUT , [Scheme] : http://localhost/exam1/board
    @ResponseBody
    public boolean 개별수정(){
        System.out.println("BoardController.개별수정");
        return true;
    }
    // 5) 개별 글 삭제 : DELETE -> @DeleteMapping
    @DeleteMapping("/exam1/board")      // Talend API : [METHOD] DELETE , [Scheme] : http://localhost/exam1/board
    @ResponseBody
    public int  개별삭제(){
        System.out.println("BoardController.개별삭제");
               return 3;
    }

}
