package web.controller;

import jakarta.annotation.ManagedBean;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;

@RestController // (1) HTTP 요청/응답 자료 매핑 기술
@RequestMapping("/post") // (2) HTTP URL 매핑 기술
@RequiredArgsConstructor // (3) final 변수에 대한 자동 생성자 주입
public class PostController {
    private final PostService postService; // @RequiredArgsConstructor사용함으로 @Aotowired 생략한다.

    // 게시물등록
    @PostMapping("")
    // method
    public int writePost(@RequestBody  PostDto postDto , HttpSession session){
        // 1. 현재 로그인 상태 확인
        Object login = session.getAttribute("loginMno");
        // 2. 비로그인이면 등록실패 처리
        if( login == null ) return 0;
        // 3. 로그인이면 현재 로그인한 회원번호를 postDto 대입하기
        int mno = (int)login;
        postDto.setMno(mno);
        // 4. 서비스호출하고 응답 반환하기
        return postService.writePost(postDto);
    }

    // [2] 게시물 전체 조회
    public PageDto findAllPost(@RequestParam( defaultValue = "1") int cno, // defaultValue : 값생략시 기본값 대입
                               @RequestParam( defaultValue = "1") int page,
                               @RequestParam( defaultValue = "5") int count ){
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 없으면 defalutValue 속성으로 기본값 대입 할수 있다.
        return postService.finaAllPost( cno , page, count );

    }


}// class e
