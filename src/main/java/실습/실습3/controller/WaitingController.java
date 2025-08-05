package 실습.실습3.controller;

import org.springframework.web.bind.annotation.*;
import 실습.실습3.model.dao.WaitingDao;
import 실습.실습3.model.dto.WaitingDto;
import 종합.예제11.model.dto.BoardDto;

import java.util.ArrayList;

@RestController// 싱글톤 대용
public class WaitingController {
    // (*) Controller는 Dao만 호출 할 수있다. dao 싱글톤 호출
    private WaitingDao waitingDao = WaitingDao.getInstance();

    // (1) 등록기능 구현
    @PostMapping("/waiting")
    public boolean waitingWrite(@RequestBody WaitingDto waitingDto ) {
        // --> dto에 2개로 만든 생성자를 만들거나, 빈자리에 0 / null 을 적는다.
        // 3. 객체화된 dto를 dao에게 전달후 결과를 받는다.
        boolean result = waitingDao.waitingWrite( waitingDto );
        // 4. 결과를 view에게 리턴한다.
        return result;
    }
    // (2) 전체조회 기능 구현
    @GetMapping("/waiting")
    public ArrayList<WaitingDto> waitingPrint() {
        // - 유효성검사 ~ // - 매개변수~
        // 3. dao에게 요청후 결과받기
        ArrayList<WaitingDto> result = waitingDao.waitingPrint();
        // 4. 결과를 view에게 리턴한다.
        return result;
    }

    // (3) 취소/삭제 기능 구현
    @DeleteMapping("/waiting")
    public boolean waitingDelete( @RequestParam int wno ) {
        // 1. 유효성검사  // 2. 객체화
        // 3. dao에게 삭제할 번호 전달후 결과를 받는다.
        boolean result = waitingDao.waitingDelete(wno);
        // 4. 결과를 view에게 리턴한다.
        return result;
    }
    // (4) 수정 기능 구현
    @PutMapping("/waiting")
    public boolean waitingUpdate( @RequestBody WaitingDto waitingDto ) {
        // 3. dao에게 삭제할 번호 전달후 결과를 받는다.
        boolean result = waitingDao.waitingUpdate( waitingDto );
        // 4. 결과를 view에게 리턴한다.
        return result;
    }

}// class e
