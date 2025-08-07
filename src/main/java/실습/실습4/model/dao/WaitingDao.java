package 실습.실습4.model.dao;

import lombok.Getter;
import 실습.실습4.model.dto.WaitingDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static javax.management.remote.JMXConnectorFactory.connect;

public class WaitingDao {
    // 싱글톤
    @Getter
    private static final WaitingDao instance = new WaitingDao();
    private WaitingDao(){ connect(); }
    // DB 정보
    private String db_url = "jdbc:mysql://localhost:3306/실습4";
    private String db_user = "root";
    private String db_password = "1234";
    private Connection conn;
    // 연동 코드
    private void connect() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(db_url, db_user, db_password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // 1. 등록 : Controller로 부터 studentDto를 매개변수로 받아서 처리후 boolena(true/false)반환 메소드
    public boolean save(WaitingDto waitingDto ){
        try{// 예외처리
            String sql ="insert into waiting( wno, phone, count ) values( ? , ? , ? )"; //1) SQL 작성한다.
            PreparedStatement ps = conn.prepareStatement(sql); // 2) 연동된 DB에 작성한 SQL 를 기재한다.
            ps.setInt( 1, waitingDto.getWno() );//  3) 기재된 SQL에 매개변수 대입
            ps.setString( 2, waitingDto.getPhone() );
            ps.setInt( 3 , waitingDto.getCount() );
            // INSERT/UPDATE/DELETE -> executeUpdate , SELECT -> executeQuery
            int count = ps.executeUpdate();
            if( count == 1 ) return true; // 5) 결과 , 1개 저장 했으면 성공
        } catch (Exception e) {
            System.out.println(e);
        }
        return false; // 아니면 실패
    }

    // 2. 전체조회
    public List<WaitingDto> find() {
        List<WaitingDto> list = new ArrayList<>();
        try {
            String sql = "select * from waiting"; // 1) SQL 작성한다.
            PreparedStatement ps = conn.prepareStatement(sql); // 2) 연동된 DB에 작성한 SQL 를 기재한다.
            ResultSet rs = ps.executeQuery(); // 4) 기재된 SQL 실행한다.
            // INSERT/UPDATE/DELETE -> executeUpdate , SELECT -> executeQuery
            // rs.next() : SQL 조회 결과 중 다음 레코드 이동 함수
            // 하나조회 : if( rs.next() ) , 다수조회 : while( rs.next() )
            while (rs.next()) {
                WaitingDto waitingDto = new WaitingDto(// *******하나의 레코드를 DTO로 준비*******
                        rs.getInt(1),// 첫번째, 대기번호
                        rs.getString("phone"), // 연락처
                        rs.getInt("count"),/// 인원수
                        rs.getString("wdate") // dateTime 은 String 타입 으로 가져오기.
                );
                list.add( waitingDto); // 하나의 DTO를 리스트에 대입한다.
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


}// class e
