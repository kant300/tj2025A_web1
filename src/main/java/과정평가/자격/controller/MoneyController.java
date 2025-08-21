package 과정평가.자격.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import 과정평가.자격.model.dto.MoneyDto;
import 과정평가.자격.model.dto.TotalMoneyDto;
import 과정평가.자격.service.MoneyService;

import java.util.ArrayList;

@RestController
@RequestMapping("/money")
public class MoneyController {
    @Autowired private MoneyService moneyService;
    // [1] 매출정보 전체조회 moneyPrint()
    @GetMapping("")
    public ArrayList<TotalMoneyDto> moneyPrint(){
        ArrayList<TotalMoneyDto> list = moneyService.moneyPrint();
        return list;
    }


}// class e
