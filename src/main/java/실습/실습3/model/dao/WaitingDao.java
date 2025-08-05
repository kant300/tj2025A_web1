package 실습.실습3.model.dao;

import 실습.실습3.model.dto.WaitingDto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class WaitingDao {
    // (*) 싱글톤
    private WaitingDao() { connect(); }
    private static final WaitingDao instance = new WaitingDao();
    public static WaitingDao getInstance() { return instance; }

    // (*) DB 연동
    private String db_url = "jdbc:mysql://localhost:3306/실습3";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    private void connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection( db_url , db_user , db_password );
        }catch (Exception e ){ System.out.println(e);   }
    }

    // (1) 등록 기능 구현
    public boolean waitingWrite( WaitingDto waitingDto ) {
        // boolean  : 해당 메소드 실행 결과를 true(저장성공) false(저장실패) 반환하기 위한 타입
        // WaitingDto waitingDto    : controller로부터 저장할 값들을 dto로 구성해서 받는 매개변수
        try {
            // 1. SQL 작성한다.
            String sql = "insert into waiting( phone , count ) values( ? , ? )";
            // 2. SQL 기재한다.
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입 , 현재 ? 2개
            ps.setString(1, waitingDto.getPhone() );
            ps.setInt(2, waitingDto.getCount() );
            // 4. SQL 실행 , insert/update/delete 은 .executeUpdate();
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if (count >= 1) return true; // 1개이상 insert했으면 저장성공
            return false; // 1개 이상 insert 못했으면 저장 실패
        } catch (Exception e) { System.out.println(e); }
        return false;  // 예외 발생시 저장 실패
    }
    // (2) 전체조회 기능 구현
    public ArrayList<WaitingDto> waitingPrint() {
        // ArrayList<WaitingDto> : *배열* 대신에 다양한 편의성 기능을 제공하는 ArrayList 클래스
        ArrayList<WaitingDto> list = new ArrayList<>(); // 조회된 레코드(DTO) 들을 저장할 리스트 선언
        try{
            // 1. SQL 작성한다.
            String sql = "select * from waiting";
            // 2. SQL 기재한다.
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입 , SQL 문법에? (매개변수) 가 없어서 생략
            // 4. SQL 실행 , select = executeQuery()
            ResultSet rs = ps.executeQuery();
            // 5. SQL 결과에 따른 로직/리턴/확인
            // 1) select 조회결과를 레코드/행/가로단위 하나씩 조회
            while ( rs.next() ){ //rs.next() : ResultSet 인터페이스가 갖는 (조회)결과 테이블에서 다음 레코드 이동 뜻
                int wno = rs.getInt( "wno" ); // rs.get타입("가져올속성명 or 번호")
                String phone = rs.getString( "phone" );
                int count = rs.getInt( "count" );
                WaitingDto waitingDto = new WaitingDto( wno , phone ,count );
                // 레코드1개(열3걔 --> DTO(멤버변수3개) 1개
                // 3) 생성된 dto를 리스트에 담아주기
                list.add( waitingDto );
            } //while e
        } catch (Exception e) { System.out.println(e); }
        return list;
    }

    // (3) 취소/삭제 화면 구현
    public boolean waitingDelete( int wno ) {  // int wno : 매개변수이면서 삭제할 게시물의 식별(pk)번호
        try{
            // 1. SQL 작성한다.
            String sql = "delete from waiting where wno = ?";
            // 2. SQL 기재한다.
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입
            ps.setInt( 1 , wno ); // SQL 문법내 첫번째 ? 의 INT타입으로 wno 값 대입
            // 4. SQL 실행 , insert/update/delete 문법 실행 결과는 처리된 레코드수 반환
            int count = ps.executeUpdate();
            // 5. SQL 결과에 따른 로직/리턴/확인
            if( count == 1 ) { return true; } // <--- sql결과 1이면 취소성공
            else{ return false; } // <--- sql결과 1아니면 취소실패
        } catch (Exception e) { System.out.println(e); }
        return false; // <--- 예외발생시 삭제실패
    }

    // (4) 수정 기능 구현
    public boolean waitingUpdate ( WaitingDto waitingDto ) {
        try {
            // 1. SQL 작성한다.
            String sql = "update waiting set count = ? where wno = ?";
            // 2. SQL 기재한다.
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. SQL 매개변수 대입 , SQL 문법내 ? 개수만큼 대입
            ps.setInt(1, waitingDto.getCount());
            ps.setInt(2, waitingDto.getWno());// 2 작성한 이유 : SQL 문법내 두번째 ? 자리에 bno 값 대입
            // 4. SQL 실행
            int count = ps.executeUpdate();
            if (count == 1) return true;  // 수정sql 결과가 1개이면 수정성공
            // 5. SQL 결과에 따른 로직/리턴/확인
        } catch (Exception e) {
            System.out.println(e);
        }
        return false; // 예외발생시 수정실패
    }

}// class e
