package web.model.dao;


import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository // 스프링 컨테이너에 빈등록
public class MemberDao extends Dao {
    // [1] 회원가입
    public int signUp( MemberDto memberDto ){
        try{
            String sql="insert into member( mid,mpwd,mname,mphone) values(?,?,?,?)"; // 1. sql 작성한다.
            // 2. sql 기재한다. + *** auto_increment(자동PK) 값 결과를 반환 설정 ***
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            // 3. sql문법내 매개변수 대입
            ps.setString(1, memberDto.getMid() );
            ps.setString(2, memberDto.getMpwd());
            ps.setString(3, memberDto.getMname());
            ps.setString(4, memberDto.getMphone());
            // 4. 기재된 sql 실행한 결과 레코드 저장개수 반환
            int count = ps.executeUpdate();
            if(count==1){
                // 5. auto_increment로 자동 할당된 pk값 반환하여 rs로 조작하기
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){ // 자동할당된 pk값중에 첫번째 pk값으로 이동
                    int mno = rs.getInt(1); //pk값 가져오기
                    return mno; // 회원가입 성공한 회원의 번호를 반환한다.
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }
    // [2] 로그인
    public int login( MemberDto memberDto ){
        try{
            String sql="select * from member where mid = ? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMid());
            ps.setString( 2, memberDto.getMpwd());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int mno = rs.getInt("mno");
                return mno;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }




}// class e
