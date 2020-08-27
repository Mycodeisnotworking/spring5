package spring;

public class Client2 {
	
	private String host;
	
	public void setHost(String host){
		this.host = host;
	}
	
	public void connect(){//초기화 과정에서 실행해야함.
		System.out.println("Client2.connect() 실행");
	}
	
	public void send(){
		System.out.println("Client2.send() to "+host);
	}
	
	public void close(){//소멸 과정에서 실행해야 함.
		System.out.println("Client2.close() 실행");
	}
	
}
