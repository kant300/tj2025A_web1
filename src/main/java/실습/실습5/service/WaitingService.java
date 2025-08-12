package 실습.실습5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 실습.실습5.model.dao.WaitingDao;
import 실습.실습5.model.dto.WaitingDto;

import java.sql.PreparedStatement;
import java.util.List;

@Service
public class WaitingService {
    @Autowired private WaitingDao waitingDao;
    // [1] 등록
    public boolean waitingWrite(WaitingDto waitingDto){
        System.out.println("WaitingService.waitingWrite");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingWrite( waitingDto);
        return result;
    }

    // [2] 전체조회
    public List<WaitingDto> waitingPrint(){
        System.out.println("WaitingService.waitingPrint");
        List<WaitingDto> result = waitingDao.waitingPrint();
        return result;
    }

    // [3] 개별조회
    public WaitingDto waitingView( int wno ){
        System.out.println("WaitingService.waitingView");
        System.out.println("wno = " + wno);
        WaitingDto result = waitingDao.waitingView( wno );
        return result;
    }

    // [4] 개별삭제
    public boolean waitingDelete( int wno ){
        System.out.println("WaitingService.waitingDelete");
        System.out.println("wno = " + wno);
        boolean result = waitingDao.waitingDelete( wno );
        return result;
    }

    // [5] 개별수정
    public boolean waitingUpdate( WaitingDto waitingDto ){
        System.out.println("WaitingService.waitingUpdate");
        System.out.println("waitingDto = " + waitingDto);
        boolean result = waitingDao.waitingUpdate( waitingDto );
        return result;
    }


}//class e
