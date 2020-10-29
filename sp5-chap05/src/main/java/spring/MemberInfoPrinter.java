package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("infoPrinter")
public class MemberInfoPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			System.out.println("�뜲�씠�꽣 �뾾�쓬");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	/*
	 * setter �궗�슜 �떆(Java Bean 洹쒖튃)
	 * 
	 * 硫붿꽌�뱶 �씠由꾩� set�쑝濡� �떆�옉
	 * set �떎�쓬 泥リ��옄�뒗 ��臾몄옄
	 * �뙆�씪誘명꽣�뒗 1媛�
	 * return void
	 * */
	@Autowired
	public void setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	@Autowired
	@Qualifier("printer")
	public void setPrinter(MemberPrinter printer){
		this.printer = printer;
	}
}
