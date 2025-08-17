package 과정평가.자격.model.dao;

import org.springframework.stereotype.Repository;
import 과정평가.자격.model.dto.MemberDto;

import java.sql.PreparedStatement;

@Repository
public class MemberDao extends  Dao {
// [1] 회원등록 memberWrite()
    public boolean memberWrite(MemberDto memberDto){
        System.out.println("MemberDao.memberWrite");
        System.out.println("memberDto = " + memberDto);
        try{
            // 1.sql작성한다.
            String sql = "insert into member(custname,phone,address,joindate,grade,city) values( ?,?,?,?,? )";
            // 2.sql기재한다.
            PreparedStatement ps = conn.prepareStatement(sql);
            // 3. 매개변수 대입한다.
            ps.setString(1,memberDto.getCustname());
            ps.setString(2,memberDto.getPhone());
            ps.setString(3,memberDto.getAddress());
            ps.setString(4,memberDto.getJoindate());
            ps.setString(5,memberDto.getGrade());
            ps.setString(6,memberDto.getCity());
            // 4. 실행
            int count = ps.executeUpdate(); // insert
            // 5. 결과확인
            if( count == 1 ){ return true; }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }




}// class e

