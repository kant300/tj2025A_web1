package 과정평가.자격.model.dao;

import org.springframework.stereotype.Repository;
import 과정평가.자격.model.dto.MoneyDto;
import 과정평가.자격.model.dto.TotalMoneyDto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

@Repository
public class MoneyDao extends Dao{
    // [1] 매출정보 전체조회 moneyPrint()
    public ArrayList<TotalMoneyDto> moneyPrint(){
        ArrayList<TotalMoneyDto> list = new ArrayList<>();
        try{
            String sql = "select m.custno, m.custname, m.grade, sum(o.price) as totalSales "
                    + "from money o inner join member m on m.custno = o.custno "
                    + "group by m.custno, m.custname, m.grade order by totalSales desc;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TotalMoneyDto totalMoneyDto = new TotalMoneyDto(
                        rs.getInt("custno"),
                        rs.getString("custname"),
                        rs.getString("grade"),
                        rs.getInt("totalSales")
                );
                list.add(totalMoneyDto);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}

