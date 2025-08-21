package 과정평가.자격.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 과정평가.자격.model.dao.MemberDao;
import 과정평가.자격.model.dto.MemberDto;

import java.util.ArrayList;

@Service
public class MemberService {
    @Autowired private MemberDao memberDao;
    // [1] 회원등록
    public boolean memberWrite(MemberDto memberDto){
        System.out.println("MemberService.memberWrite");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberDao.memberWrite(memberDto);
        return result;
    }
    // [2] 회원정보조회 memberPrint()
    public ArrayList<MemberDto> memberPrint(){
        ArrayList<MemberDto> list = memberDao.memberPrint();
        return list;
    }
    // [3] 회원개별조회 memberList()
    public MemberDto memberList( int custno){
        MemberDto memberDto = memberDao.memberList(custno);
        return memberDto;
    }

    // [4] 회원정보수정 memberUpdate()
    public boolean memberUpdate( MemberDto memberDto){
        boolean result = memberDao.memberUpdate(memberDto);
        return result;
    }

    // [5] 회원정보삭제  memberDelete()
    public boolean memberDelete(int custno){
        boolean result = memberDao.memberDelete(custno);
        return result;
    }
    // [6] max custno 추출
    public int maxCustno(){
        int result = memberDao.maxCustno();
        return result;
    }

}//class e
