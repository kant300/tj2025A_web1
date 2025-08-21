package 과정평가.자격.model.dao;

import org.springframework.stereotype.Repository;
import 과정평가.자격.model.dto.MemberDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class MemberDao extends  Dao {
// [1] 회원등록 memberWrite()
    public boolean memberWrite(MemberDto memberDto){
        System.out.println("MemberDao.memberWrite");
        System.out.println("memberDto = " + memberDto);
        try{
            // 1.sql작성한다.
            String sql = "insert into member(custname,phone,address,joindate,grade,city) values( ?,?,?,?,?,? )";
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

    // [2] 회원정보조회 memberPrint()
       public ArrayList<MemberDto> memberPrint() {
        ArrayList<MemberDto> list = new ArrayList<>();
        try {
            String sql = "select * from member order by custno desc";//최신회원부터 보이도록 정렬
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MemberDto memberDto = new MemberDto(
                        rs.getInt("custno"),
                        rs.getString("custname"),
                        rs.getString("phone"),
                        rs.getString("address"),
                        rs.getString("joindate"),
                        rs.getString("grade"),
                        rs.getString("city")
                );
                list.add(memberDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
// [3] 회원개별조회 memberList()
public MemberDto memberList(int custno) {
    MemberDto memberDto = null; //초기값을 null로 설정
    try {
        String sql = "select * from member where custno = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1,custno);
        ResultSet rs = ps.executeQuery();
        if(rs.next()) {
            memberDto.setCustno(rs.getInt("custno"));
            memberDto.setCustname(rs.getString("custname"));
            memberDto.setPhone(rs.getString("phone"));
            memberDto.setAddress(rs.getString("address"));
            memberDto.setJoindate(rs.getString("joindate"));
            memberDto.setGrade(rs.getString("grade"));
            memberDto.setCity(rs.getString("city"));
        }
    } catch (Exception e) {
        System.out.println("MemberDao.memberView" + e);
    }
    return memberDto;
} //func e

    // [4] 회원정보수정 memberUpdate()
    public boolean memberUpdate(MemberDto memberDto){
        boolean result = false;
        try{
            String sql = "update member set custname=?, phone=?, address=?, joindate=?, grade=?, city=? where custNo= ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,memberDto.getCustname());
            ps.setString(2,memberDto.getPhone());
            ps.setString(3,memberDto.getAddress());
            ps.setString(4,memberDto.getJoindate());
            ps.setString(5,memberDto.getGrade());
            ps.setString(6,memberDto.getCity());
            ps.setInt(7,memberDto.getCustno());
            int count = ps.executeUpdate();
            if( count == 1 ){
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
// [5] 회원정보삭제  memberDelete()
    public boolean memberDelete(int custno){
        boolean result = false;
        try{
            String sql = "delete from member where custno = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, custno);
            int count = ps.executeUpdate();
            if(count == 1){
                result = true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    // [6] max custno 추출
    public int maxCustno() {
        int result = 0; // 초기값을 0으로 설정
        try {
            String sql = "select max(custno) as maxCustno from member";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            result = rs.getInt("max(custno)") + 1;
            }else {
                result = 1; // 테이블에 데이터가 없는 경우 1부터 시작
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }
}// class e

