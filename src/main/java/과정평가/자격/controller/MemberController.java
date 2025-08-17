package 과정평가.자격.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 과정평가.자격.model.dto.MemberDto;
import 과정평가.자격.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired private MemberService memberService;

    // [1] 회원등록
    @PostMapping("") // localhost:8080/member
    public boolean memberWrite(@RequestBody MemberDto memberDto ){
        System.out.println("MemberController.memberWrite");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberService.memberWrite(memberDto);
        return result;
    }


}// class e
