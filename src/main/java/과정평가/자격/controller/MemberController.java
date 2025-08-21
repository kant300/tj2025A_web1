package 과정평가.자격.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import 과정평가.자격.model.dto.MemberDto;
import 과정평가.자격.service.MemberService;

import java.util.ArrayList;

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
    // [2] 회원정보전체조회 memberPrint()
    @GetMapping("")
    public ArrayList<MemberDto> memberPrint(){
        ArrayList<MemberDto> list = memberService.memberPrint();
        return list;
    }

    // [3] 회원정보개별조회 memberList(){
    @GetMapping("/list")
    public MemberDto memberList( int custno){
        MemberDto memberDto = memberService.memberList(custno);
        return memberDto;
    }

    // [4] 회원정보수정 memberUpdate()
    @PutMapping("")
    public boolean memberUpdate(@RequestBody MemberDto memberDto){
        boolean result = memberService.memberUpdate(memberDto);
        return result;
    }

    // [5] 회원정보삭제  memberDelete()
    @DeleteMapping("")
    public boolean memberDelete(int custno){
        boolean result = memberService.memberDelete(custno);
        return result;
    }

    // [6] max custno 추출
    @GetMapping("/custno")
    public int maxCustno(){
        int result = memberService.maxCustno();
        return result;
    }







}// class e
