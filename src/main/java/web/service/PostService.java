package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.PostDao;
import web.model.dto.PageDto;
import web.model.dto.PostDto;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor // 롬복제공 : final 변수에 대한 ---(final)생성자 자동---제공
public class PostService {
    // (*) @RequiredArgsConstructor 사용시
    private final PostDao postDao;
    // (*) @RequiredArgsConstructor 미사용시
//    private final PostDao postDao;
//    @Autowired
//    public PostService( PostDao postDao){
//        this.postDao = postDao;
//    }
    // [1] 게시물등록
    public int writePost(PostDto postDto){
       return postDao.writePost( postDto);
    }

    // [2] 게시물 전체조회 *페이징*
    public PageDto finaAllPost( int cno, int page, int count , String key , String keyword ){
        // cno : 카테고리번호, page : 현재페이지번호, count : 페이지당 게시물수
        // ****** 1. 페이지별 조회할 시작( 인덱스) 번호 계산 ******
        // * 페이지당 5개씩 조회한다는 가정 : 1페이지 -> 1. 2페이지 -> 6 , 3페이지-> 11
        int startRow= ( page -1 ) * count; // 현재페이지-1 하고 페이지당 게시물수 곱한다.
        // 1페이지 -> 1-1*5 -> 0 , 2페이지 -> 2-1*5 -> 5 , 3페이지 -> 3-1*5 -> 10
        // 예] 네이버 증권게시판
        // 1페이지 -> 1-1*20 -> 0 , 2페이지 -> 2-1*20 -> 20 , 3페이지 -> 3-1*20 -> 40
        // ******* 2,3번만 검색이 있을때 없을때를 나눠서 totalCount 와 postList 구해보자 *******
        int totalCount;
        // ****** 3. 자료의 구하기 (어제것을 아래에서 위로 위치바꾸기 )
        List<PostDto> postList;
        //int totalCount = postDao.getTotalCount( cno );
        if( key != null && !key.isEmpty() && keyword != null && !keyword.isEmpty() ){ // (1) 검색일때
            // 만약에 key 와 keyword 가 null 아니면서.isEmpty() : 비어있으면 true 반환 함수 [!부정문 ]
            // .(도트/접근)연산자는 변수가 NULL 일때 사용 안된다.( NullPointerException )

            totalCount = postDao.getTotalCountSearch( cno , key , keyword );
            postList = postDao.findAllSearch( cno , startRow , count , key , keyword );
        }else{  // (2) 검색이 아닐떄
            totalCount = postDao.getTotalCount( cno );
            postList = postDao.findAll( cno , startRow , count );
        }

        // ****** 4. 전체 페이지수 구하기 ******
        int totalPage = totalCount % count == 0 ? totalCount/count : totalCount/count + 1; // 나머지가 존재하면 +1
        // * 35개의 정보가 있을때 5개씩 조회한다면 총 페이지수는 몇개 ? 7페이지
        // * 42개의 정보가 있을때 10개씩 조회한다면 총 페이지수는 몇개 ? 4페이지 + 1페이지(나머지 2개) => 5페이지
        int btnCount = 5; // 한 화면에 보여지는 최대 버튼수
        // ****** 5. 시작버튼 구하기 *****
        int startBtn =( (page -1) / btnCount ) * btnCount +1;
        // ****** 6. 끝버튼 구하기 *****
        int endBtn = startBtn + btnCount -1;
        if( endBtn > totalPage ) endBtn = totalPage; // 만약에 끝버튼수가 총페이지수보다 커지면 총페이지수로 끝버튼번호 사용
        // * 총 페이지수가 13일때, 현재 페이지가 3이면 시작버튼 : 1 ,  끝버튼 : 5
        // * 총 페이지수가 13일때, 현재 페이지가 7이면 시작버튼 : 6 ,  끝버튼 : 10
        // * 총 페이지수가 13일때, 현재 페이지가 12이면 시작버튼 : 11 ,  끝버튼 : 13(마지막페이지수)
        // ****** 6. 자료요청, cno : 카테고리번호, startRow(시작인덱스) , count(페이지당게시물수) *****
        // SQL페이징 처리 : limit 시작인덱스, 개수
        // 1페이지 : limit 0 , 5   / 2페이지 : limit 5 , 5    / 3페이지 : limit 10 , 5
        // ****** pageDto 구하기 *****
        PageDto pageDto = new PageDto();
        pageDto.setCurrentPage( page );     // 현재페이지 번호
        pageDto.setTotalPage( totalPage );  // 전체페이지 수
        pageDto.setPreCount( count );       // 한페이지당 게시물 수
        pageDto.setTotalCount( totalCount );    // 전체게시물 수
        pageDto.setStartBtn( startBtn );        // 시작 페이징 버튼번호
        pageDto.setEndBtn( endBtn );        // 끝 페이징 버튼번호
        pageDto.setData( postList );    // 페이지한 게시물 리스트
        return pageDto;     // 반환
    }
    // [3-1] 게시물 개별 정보조회
    public PostDto getPost( int pno ){
        return postDao.getPost( pno );
    }
    // [3-2] 게시물 조회수 1증가
    public void incrementView( int pno ){
        postDao.incrementView( pno );
    }
//    // [3-1]과 [3-2] 하나로
//    public PageDto getPost( int pno ){
//        postDao.incrementView( pno );
//        return postDao.getPost( pno );
//    }
    // [4] 개별삭제 :  DAO의 deletePost 메서드를 호출하여 게시물 삭제를 요청하고 결과를 반환
    public boolean deletePost( int pno ){
        return postDao.deletePost(pno);
    }

    // [5] 개별수정 : DAO의 updatePost 메서드를 호출하여 게시물 수정을 요청하고 결과를 반환
    public int updatePost( PostDto postDto ){
        return postDao.updatePost( postDto );
    }

    // [6] 댓글등록
    public int writeReply( Map<String ,String > reply){
        return postDao.writeReply( reply );
    }

    // [7] 댓글전체조회
    public List< Map<String , String >> findAllReply( int pno ){
        return postDao.findAllReply(pno);
    }


}//class e
