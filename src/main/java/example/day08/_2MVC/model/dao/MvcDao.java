package example.day08._2MVC.model.dao;

import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@Repository // [3] @Repository 빈 등록 - 싱글톤 완성
public class MvcDao extends Dao {
    // 다음 레이어(계층) 없어서 @Autowired 없다.
    // extends Dao할 경우 db연동 상속받아 사용한다. -> Dao 슈퍼클래스 만듬

    public void method() {
        System.out.println("MvcDao.method");
        try {
            String sql = "select * from mvc";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString("var1"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
