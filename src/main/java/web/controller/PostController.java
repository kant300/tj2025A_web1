package web.controller;

import jakarta.annotation.ManagedBean;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.IPv6Utils;
import org.springframework.web.bind.annotation.*;
import web.model.dto.PageDto;
import web.model.dto.PostDto;
import web.service.PostService;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SplittableRandom;

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
    @GetMapping("") //
    // 검색이 없을 때 : method : GET   , URL : localhost:8080/post?cno=1&page=1&count=5
    // 1번 카테고리(뉴스)의 1페이지의 5개 게시물
    // 검색이 있을 때 : method : GET   , URL : localhost:8080/post?cno=1&page=1&count=5&key=ptitle&keyword=ai ,
    // 1번카테고리(뉴스)의 1페이지에서 제목의 ai가 포함된
    public PageDto findAllPost(@RequestParam( defaultValue = "1") int cno, // defaultValue : 값생략시 기본값 대입
                               @RequestParam( defaultValue = "1") int page,
                               @RequestParam( defaultValue = "5") int count,
                               @RequestParam( required = false ) String key,
                               @RequestParam( required = false) String keyword ){
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 없으면 defalutValue 속성으로 기본값 대입 할수 있다.
        // 만약에 URL 주소상의 지정한 쿼리스트링 매개변수가 존재하는 조건이 필수가 아닐때 required = false 속성을 사용한다.
        return postService.finaAllPost( cno , page, count , key, keyword );

    }

    // [3] 개별조회
    @GetMapping("/view")
    public PostDto getPost( @RequestParam int pno , HttpSession session ){
        // HttpSession : 브라우저마다 별도의 저장소 개념
            // 1. 세션 속성내 'viewHistory' 값 가져오기
        Object object = session.getAttribute("viewHistory");

        Map< Integer , String > viewHistory;
            // 2. 만약에 'viewHistory' 가 존재하지 않으면
        if( object == null ){
            viewHistory = new HashMap<>();
        }else{ // 3. 존재하면 기존 자료를 타입변환한다.
            viewHistory = (Map< Integer , String >) object;
        }
            // 4. 오늘 날짜를 문자열로 가져옴
        String today = LocalDate.now().toString();
            // 5. 현재 게시물(pno)을 오늘(today)조합하여 본 기록을 체크한다. { 3 : 2025-08-06 , 3 : 2025-08-07 }
        String check = viewHistory.get( pno );
        if( check == null || !check.equals( today ) ) { // 만약에 현재게시물의 오늘날짜가 없거나 오늘날짜가 일치하지 않으면
            // 6. 조회수 증가 서비스 호출
            postService.incrementView( pno );
            // 7. 세션에 조회후 기록/저장
            viewHistory.put( pno, today );
            // 8. 세션 속성 업데이트
            session.setAttribute( "viewHistory" , viewHistory );
        }
        // 1. 24시간내 하나의 게시물의 1번만 조회수 증가 요청 가능

        // 2. 요청한 사람(클라이언트)이 본인이 작성할 글인지 확인

        PostDto postDto =  postService.getPost(pno);
            // 로그인 세션 확인
        Object loginObject = session.getAttribute( "loginMno"); // 로그인 세션 확인
        int loginMno = loginObject == null ? 0 : (int) loginObject; // 만약에 로그인정보가 없으면 0 있으면 타입변환
        //  만약에 조회한 게시물의 작성자 회원번호가 로그인회원번호와 같으면
        if( postDto.getMno() == loginMno ){ postDto.setHost( true ); }
        return postDto;
    }

    // [4] 개별삭제
    @DeleteMapping("")
    // @RequestParam int pno: 클라이언트로부터 쿼리 파라미터로 pno(게시물 번호)를 받습니다.
    public boolean deletePost( @RequestParam int pno ){
        // Service 계층의 deletePost 메서드를 호출하여 게시물 삭제를 처리하고 그 결과를 반환
        return postService.deletePost( pno );
    }

    // [5] 개별수정
    @PutMapping("")
    // @RequestBody PostDto postDto: 클라이언트가 전송한 JSON 데이터를 PostDto 객체로 자동 변환하여 받습니다.
    public int updatePost( @RequestBody PostDto postDto ){
        // Service 계층의 updatePost 메서드를 호출하여 게시물 수정을 처리하고 그 결과를 반환합니다.
        return postService.updatePost( postDto );
    }

    // [6] 댓글등록
    @PostMapping("/reply")
    public int writeReply( @RequestBody Map<String ,String > reply ,HttpSession session ){
        // * 회원제 댓글이라서 *세션내 로그인정보 가져오기*
        if( session.getAttribute( "loginMno") == null ) return 0; // 비로그인이면 실패

        int loginMno = (int)session.getAttribute("loginMno"); // 로그인중이면 세션에서 회원번호 조회
        reply.put("mno" , loginMno+"" ); // ?? +"" , 로그인된 회원번호를 map 추가
        return postService.writeReply( reply );
    }

    // [7] 댓글전체조회
    @GetMapping("/reply")
    public List<Map<String , String > > findAllReply( @RequestParam int pno ){
        return postService.findAllReply(pno);
    }


}// class e
