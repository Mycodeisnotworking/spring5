package spring;

public class Client2 {
	
	private String host;
	
	public void setHost(String host){
		this.host = host;
	}
	
	public void connect(){//�ʱ�ȭ �������� �����ؾ���.
		System.out.println("Client2.connect() ����");
	}
	
	public void send(){
		System.out.println("Client2.send() to "+host);
	}
	
	public void close(){//�Ҹ� �������� �����ؾ� ��.
		System.out.println("Client2.close() ����");
	}
	
}
