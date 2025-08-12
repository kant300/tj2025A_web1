package 실습.실습5.model.dao;

import org.springframework.stereotype.Repository;
import 실습.실습5.model.dto.WaitingDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class WaitingDao extends Dao {
    // [1] 등록
    public boolean waitingWrite(WaitingDto waitingDto){
        System.out.println("WaitingDao.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        try{
            String  sql ="insert into waiting( wno , phone, count) values( ? , ? , ? )";// 1. sql 작성
            PreparedStatement ps = conn.prepareStatement(sql); // 2. sql 기재
            ps.setInt( 1 , waitingDto.getWno() );// 3. sql에 매개변수 대입
            ps.setString( 2, waitingDto.getPhone() );
            ps.setInt( 3, waitingDto.getCount() );
            // INSERT/UPDATE/DELETE -> executeUpdate , SELECT -> excuteQuery
            int count = ps.executeUpdate(); // 4.실행
            if( count == 1 ) return true; // 5. 결과, 1개 저장하면 성공
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // [2] 전체조회
    public List<WaitingDto> waitingPrint() {
        System.out.println("WaitingDao.waitingPrint");
        List<WaitingDto> list = new ArrayList<>(); // 여러 레코드를 dto로 변환해서 dto들을 저장할 리스트선언
        try {
            String sql = "select * from waiting";// 1. sql 작성
            PreparedStatement ps = conn.prepareStatement(sql); // 2. sql 기재
            // INSERT/UPDATE/DELETE -> executeUpdate , SELECT -> excuteQuery
            ResultSet rs = ps.executeQuery(); // 3. 실행
            while (rs.next()) {  // rs.next() 조회된 결과에서 다음 레코드 이동
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno(rs.getInt("wno")); // rs.getInt() 현재조회중인 레코드에서 wno속성값 호출
                waitingDto.setPhone(rs.getString("phone")); // rs.getString() 현재조회중인 레코드에서 phone속성값 호출
                waitingDto.setCount(rs.getInt("count"));
                waitingDto.setDate(rs.getString("date"));
                list.add(waitingDto); // 생성한 dto를 리스트에 저장

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    // [3] 개별조회
    public WaitingDto waitingView( int wno ){
        try{
            String sql = "select * from waiting where wno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, wno );
            ResultSet rs = ps.executeQuery(); // 3. 실행
            if( rs.next() ){ // while(rs.next()) : 여러개 조회 , if( rs.next() ) : 한개 조회
                WaitingDto waitingDto = new WaitingDto();
                waitingDto.setWno( rs.getInt( 1 ) );
                waitingDto.setPhone( rs.getString( 2 ) );
                waitingDto.setCount( rs.getInt( 3 ) );
                waitingDto.setDate( rs.getString( 4) );
                return waitingDto; // 성고시 1개 dto
            }
        } catch (Exception e) {
            System.out.println(e);;
        }
        return null;
    }

    // [4] 개별삭제
    public boolean waitingDelete( int wno ){
        try{
            String sql="delete from waiting where wno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, wno );
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // [5] 개별수정
    public boolean waitingUpdate( WaitingDto waitingDto ){
        try{
            String sql="update waiting set phone=? , count = ?  where wno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1 , waitingDto.getPhone() );
            ps.setInt( 2 , waitingDto.getCount() );
            ps.setInt( 3 , waitingDto.getWno() );
            int count = ps.executeUpdate();
            if( count == 1 ) return true;
        } catch (Exception e) {
            System.out.println(e);

        }
        return false;
    }

}// class e
