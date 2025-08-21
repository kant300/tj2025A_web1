package 과정평가.자격.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 과정평가.자격.model.dao.MoneyDao;
import 과정평가.자격.model.dto.MoneyDto;
import 과정평가.자격.model.dto.TotalMoneyDto;

import java.util.ArrayList;

@Service
public class MoneyService {
    @Autowired  private MoneyDao moneyDao;
    // [1] 매출정보 전체조회 moneyPrint()
    public ArrayList<TotalMoneyDto> moneyPrint(){
        ArrayList<TotalMoneyDto> list = moneyDao.moneyPrint();
        return list;
    }
}// class e
