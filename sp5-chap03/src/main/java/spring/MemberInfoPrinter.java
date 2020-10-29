package spring;

public class MemberInfoPrinter {

	private MemberDao memberDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email){
		Member member = memberDao.selectByEmail(email);
		if(member == null){
			System.out.println("데이터 없음");
			return;
		}
		printer.print(member);
		System.out.println();
	}
	/*
	 * setter 사용 시(Java Bean 규칙)
	 * 
	 * 메서드 이름은 set으로 시작
	 * set 다음 첫글자는 대문자
	 * 파라미터는 1개
	 * return void
	 * */
	public void setMemberDao(MemberDao memberDao){
		this.memberDao = memberDao;
	}
	
	public void setPrinter(MemberPrinter printer){
		this.printer = printer;
	}
}
