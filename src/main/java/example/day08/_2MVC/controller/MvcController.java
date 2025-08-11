package example.day08._2MVC.controller;

import example.day08._2MVC.service.MvcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // [1] Controller 빈 등록 - 싱글톤완성
public class MvcController {
    @Autowired // [2]  @Service 빈 주입
    private MvcService mvcService;

    // [3] 기능처리
    @GetMapping("/day08/mvc")
    public void method(){
        System.out.println("MvcController.method");
        mvcService.method(); // 서비스의 메소드 호출
    }
}
