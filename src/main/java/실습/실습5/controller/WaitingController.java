package 실습.실습5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 실습.실습5.model.dto.WaitingDto;
import 실습.실습5.service.WaitingService;

import java.util.List;

@RestController
@RequestMapping("/waiting") // 공통 URL
public class WaitingController {
    @Autowired private WaitingService waitingService;

    // [1] 등록
    @PostMapping("/write") // localhost:8080/waiting/write
    public boolean waitingWrite(@RequestBody WaitingDto waitingDto){
        System.out.println("WaitingController.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingWrite(waitingDto);
        return result;
    }
    // [2] 전체조회
    @GetMapping("/list") // localhost:8080/waiting/list
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingController.waitingPrint");
        System.out.println();
        List<WaitingDto> result = waitingService.waitingPrint();
        return result;
    }

    // [3] 개별조회
    @GetMapping("/view") //localhost:8080/waiting/view?wno=1
    public WaitingDto waitingView( @RequestParam int wno ){
        System.out.println("WaitingController.waitingView");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingService.waitingView( wno );
        return result;
    }

    // [4] 개별삭제
    @DeleteMapping("/view") //localhost:8080/waiting/view?wno=3
    public boolean waitingDelete(@RequestParam int wno ){
        System.out.println("WaitingController.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingService.waitingDelete( wno );
        return result;
    }

    // [5] 개별수정
    @PutMapping("/update") //localhost:8080/waiting/update
    public boolean waitingUpdate( @RequestBody WaitingDto waitingDto ){
        System.out.println("WaitingController.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingService.waitingUpdate( waitingDto );
        return result;
    }



}// class e
