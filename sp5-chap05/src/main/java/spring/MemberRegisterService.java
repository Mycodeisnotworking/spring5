package spring;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberRegisterService {
	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() {
	}
	
	public Long regist(RegisterRequest req) {
		Member member = memberDao.selectByEmail(req.getEmail());
		if(member != null) {
			throw new DuplicateMemberException("dup email" + req.getEmail());
		}
		Member newMember = new Member(
				req.getEmail(), req.getPassword(), req.getName()
				, LocalDateTime.now());
		memberDao.insert(newMember);//member insert �빐�꽌 �삤瑜섏깮源�
		return newMember.getId();
	}
}
