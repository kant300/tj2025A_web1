package 과정평가.자격.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 과정평가.자격.model.dao.MemberDao;
import 과정평가.자격.model.dto.MemberDto;

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

}//class e
