package web.model.dao;


import org.springframework.stereotype.Repository;
import web.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;

@Repository // 스프링 컨테이너에 빈등록
public class MemberDao extends Dao { //JDBC 연동 상속받기
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
                return mno; // 로그인 성공시 조회한 회원번호 반환
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0; // 로그인 실패시 0반환
    }

    // [3] 로그아웃 X

    // [4] 회원정보 조회
    public MemberDto info( int mno ){
        try{
            String sql = "select * from member where mno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mno);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                MemberDto memberDto = new MemberDto(); // 패스워드 제외한
                memberDto.setMno(rs.getInt("mno"));
                memberDto.setMid(rs.getString("mid"));
                memberDto.setMname(rs.getString("mname"));
                memberDto.setMphone(rs.getString("mphone"));
                memberDto.setMdate(rs.getString("mdate"));
                return memberDto;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // [5] 특정한 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check( String type, String data ){
        try{
            // String sql = "select * from member where mid = ? ";
            // String sql = "select * from member where mphone = ? ";
            String sql="select * from member where "+type+" = ?";
            // SQL문법에서 +연산자 사용시 앞뒤 띄어쓰기 주의
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1, data );
            ResultSet rs = ps.executeQuery();
            if( rs.next()){ return true;} // 중복이면 true
        } catch (Exception e) {
            System.out.println(e);
        }
        return false; // 중복이 아니면 false
    }

    // [6] 회원정보수정
    public boolean update( MemberDto memberDto){
        try {
            String sql="update member set mname=? , mphone=? where mno=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, memberDto.getMname());
            ps.setString(2, memberDto.getMphone());
            ps.setInt(3, memberDto.getMno());
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // [7] 비밀번호 수정 : 현재 로그인된 회원의 패스워드와 일치하면 패드워드 수정
    public boolean updatePassword( int mno , Map<String , String> map ){
        try{
            String sql = "update member set mpwd = ? where mno =? and mpwd = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1 , map.get("newpwd"));// 새로운 패스워드(수정용)
            ps.setInt(2, mno);
            ps.setString(3, map.get("oldpwd")); // 기존 패스워드(확인용)
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // [8] 회원탈퇴
    public boolean delete( int mno , String  oldpwd ){ // oldpwd(삭제하기전 확인용)
        try{
            String sql = "delete from member where mno =? and mpwd =? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,mno);
            ps.setString(2, oldpwd);
            return ps.executeUpdate()==1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // [9] 아이디/비밀번호 찾기
    public String findId( Map<String , String> map){
        try{
            String sql="select mid from member where mname=? and mphone=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1, map.get("mname") );
            ps.setString( 2, map.get("mphone") );
            ResultSet rs = ps.executeQuery();
            if( rs.next() ){
                return rs.getString("mid"); //아이디반환
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null; // 일치하는 정보가 없으면 null반환
    }

    public boolean findPwd( Map<String , String> map ){
        try{
            String sql = "update member set mpwd =? where mid = ? and mpone =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString( 1, map.get("mpwd") );
            ps.setString( 2, map.get("mid") );
            ps.setString( 3, map.get("mphone") );
            int count = ps.executeUpdate();
            return count == 1;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    // [10] 비밀번호 재설정
    public boolean resetPassword(String mid , String mphone, String newpwd ){
        try{
            String sql="update member set mpwd = ? where mid =? and mphone = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, newpwd);
            ps.setString(2, mid);
            ps.setString(3, mphone);
            return ps.executeUpdate()==1; // 1개 레코드가 업데이트되면 성공
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

//    // [11] 소셜로그인
//    public int socialLogin(String socialType, String socialID){
//        try{
//            String sql="select mno from member where social_type=? anc social_id=?";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, socialType);
//            ps.setString(2,socialID);
//            ResultSet rs = ps.executeQuery();
//            if( rs.next()){
//                return  rs.getInt("mno");// 기존 회원인 경우 회원번호 반환
//            }
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return 0; // 신규회원 또는 실패시 0 반환
//    }
//
//    // [12] 소셜 회원가입
//    public int socialSignup(String sociaType, String socialId, String mname,
//                            String mphone , String )





}// class e
