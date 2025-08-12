package 과정평가.자격.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import 과정평가.자격.model.dao.MemberDao;

@Service
public class MemberService {
    @Autowired private MemberDao memberDao;
}//class e
