package 과정평가.자격.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 과정평가.자격.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired private MemberServic memberService;

    // [1] 회원등록
    @PostMapping
}// class e
