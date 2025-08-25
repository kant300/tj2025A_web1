package web.model.dao;

import org.springframework.stereotype.Repository;
import web.controller.PostController;
import web.model.dto.PostDto;

import java.lang.ref.PhantomReference;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostDao extends Dao {

    // [1] 게시물등록
    public int writePost(PostDto postDto){
        try{
            String sql = "insert into post( ptitle, pcontent, cno , mno ) values( ?,?,?,? )";
            // Statement.RETURN_GENERATED_KEYS : SQL실행시 자동 생성된 **PK 반환설정**
            PreparedStatement ps = conn.prepareStatement( sql , PreparedStatement.RETURN_GENERATED_KEYS);
            //
            ps.setString( 1, postDto.getPtitle() );
            ps.setString( 2, postDto.getPcontent() );
            ps.setInt( 3, postDto.getCno() );
            ps.setInt( 4, postDto.getMno() );
            int count = ps.executeUpdate();
            if( count == 1 ){
                ResultSet rs = ps.getGeneratedKeys(); // sql 실행후 자동 생성된 **PK반환**
                if( rs.next() )return rs.getInt(1); // 등록성공시 첫번째 pk속성값 반환
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0; // 등록실패시
    }

    // [2-1] 카테고리별 게시물 수
    public int getTotalCount( int cno ){
        try{
            String sql = "select count(*) from post where cno=?"; // count(*) : 레코드 전체수를 반환하는 함수
            PreparedStatement ps = conn.prepareStatement( sql );
            ps.setInt( 1, cno );
            ResultSet rs = ps.executeQuery();
            if( rs.next()){
                return rs.getInt( 1 );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0; // 조회결과 없으면 0반환
    }

    // [2-2] 카테고리별 전체 게시물 정보 조회
    public List<PostDto> findAll( int cno, int startRow, int count ){
        List<PostDto> list = new ArrayList<>();
        try{
            String sql = "select * from post where cno= ? order by pno desc limit ? , ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1 , cno );
            ps.setInt( 2, startRow );
            ps.setInt( 3, count );
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){
                PostDto postDto = new PostDto();
                postDto.setMno( rs.getInt("mno") );
                postDto.setCno( rs.getInt("cno") );
                postDto.setPcontent( rs.getString("pcontent"));
                postDto.setPdate( rs.getString("pdate") );
                postDto.setPview( rs.getInt("pview") );
                postDto.setPno( rs.getInt( "pno") );
                list.add( postDto );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


}// class e
