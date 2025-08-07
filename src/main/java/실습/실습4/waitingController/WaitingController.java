package 실습.실습4.waitingController;

import org.springframework.web.bind.annotation.*;
import 실습.실습4.model.dao.WaitingDao;
import 실습.실습4.model.dto.WaitingDto;

import java.util.List;

@RestController
@RequestMapping("/waiting")
public class WaitingController {
    // 0. DAO 싱글톤 불러오기
    private WaitingDao waitingDao = WaitingDao.getInstance();
    // 1. 저장/등록
    @PostMapping("/save") // localhost:8080/waiting/save
    // @PostMapping : HTTP 요청 중에 method 가 *Post* 인 요청 매핑
    // ("/URL") : HTTP 주소 만들기/정의
    public boolean save( @RequestBody WaitingDto waitingDto ){
        // body : { "phone" : "010-1111-8752" , "count" : "3" }
        System.out.println("WaitingController.save");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.save( waitingDto );
        return result;
    }

    // 전체조회
    @GetMapping("/find")
    public List<WaitingDto> find() {
        System.out.println("WaitingController.find");
        List<WaitingDto> result = waitingDao.find();
        return result;
    }

}// class e
