package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.dao.MemberDao;
import web.model.dto.MemberDto;

import java.util.Map;

@Service // 스프링 컨테이너(메모리) 빈(객체)등록
public class MemberService {
    @Autowired// 스프링 컨테이너(메모리)에 등록된 빈 주입(꺼내) 받기
    private MemberDao memberDao;

    // [1] 회원가입
    public int singUp(MemberDto memberDto){
        int result = memberDao.signUp( memberDto );
        return result;
    }
    // [2] 로그인
    public int login( MemberDto memberDto ){
        int result = memberDao.login(memberDto);
        return result;
    }

    // [3] 로그아웃X

    // [4] 회원정보조회
    public MemberDto info(int mno){
        MemberDto result= memberDao.info(mno);
        return result;
    }

    // [5] 특정한 필드/열/컬럼 의 값 중복/존재 확인
    public boolean check( String type, String data ){
        boolean result = memberDao.check( type , data );
        return result;
    }

    // [6] 회원정보수정
    public boolean update( MemberDto memberDto){
        boolean result = memberDao.update( memberDto);
        return result;
    }

    // [7] 비밀번호 수정
    public boolean updatePassword(int mno , Map<String , String> map ){
        boolean result = memberDao.updatePassword(mno, map);
        return result;
    }

    // [8] 회원탈퇴
    public boolean delete(int mno, String oldpwd){
        boolean result = memberDao.delete(mno, oldpwd);
        return result;
    }

    // [9] 아이디찾기
    public String findID(String mname, String mphone){
        return memberDao.findId(mname, mphone);
    }

    // [10] 비밀번호 재설정
    public boolean resetPassword(String mid, String mphone, String newpwd ){
        // 비밀번호 암호화로직을 여기에 추가하는 것이 좋습니다.
        // 현재는 단순문자열이지만, 실제로는 암호화도니 비밀번호를 저장해야 합니다.
        return memberDao.resetPassword(mid,mphone, newpwd);
    }





}// class e
