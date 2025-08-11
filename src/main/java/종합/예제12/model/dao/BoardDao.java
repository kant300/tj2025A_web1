package 종합.예제12.model.dao;

import org.springframework.stereotype.Repository;
import 종합.예제12.model.dto.BoardDto;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDao extends Dao{
    // (1) 등록 기능 구현
    public boolean boardWrite(BoardDto boardDto ){
        try{
            String sql = "insert into board( bcontent , bwriter ) values ( ? ,? );";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1, boardDto.getBcontent() );
            ps.setString( 2, boardDto.getBwriter() );
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    // (2) 전체조회 기능 구현
    public List<BoardDto> boardPrint() {
        List<BoardDto> list = new ArrayList<>();
        try {
            String sql = "select *from board";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while ( rs.next() ){ // 조회된 결과에서 다음 레코드 이동
                BoardDto boardDto = new BoardDto();
                boardDto.setBno( rs.getInt( "bno") );
                boardDto.setBcontent( rs.getString("bcontent") );
                boardDto.setBwriter( rs.getString("bwriter") );
                list.add( boardDto );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // [3] 개별조회
    public BoardDto boardFind( int bno ){
        try{
            String sql = "select * from board where bno = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, bno );
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
               BoardDto boardDto = new BoardDto();
               boardDto.setBno( rs.getInt( 1) );
               boardDto.setBcontent( rs.getNString( 2) );
               boardDto.setBwriter( rs.getString( 3) );
               return boardDto;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // [4] 삭제
    public boolean boardDelete( int bno ) {
        try {
            String sql = "delete from board where bno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, bno);
            int count = ps.executeUpdate();
            if (count == 1) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
        // [5] 개별수정
       public boolean boardUpdate( BoardDto boardDto ){
           try{
               String sql = "update board set bcontent = ? where bno = ? ";
               PreparedStatement ps = conn.prepareStatement(sql);
               ps.setString( 1, boardDto.getBcontent() );
               ps.setInt( 2, boardDto.getBno() );
               int count = ps.executeUpdate();
               if ( count == 1 ) return true;

           }catch (Exception e){
               System.out.println(e);}
           return false;
        }

}//class e
