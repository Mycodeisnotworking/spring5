package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import spring.Client;
import spring.Client2;

@Configuration
public class AppCtxWithPrototype {
	
	@Bean
	@Scope("prototype")//Prototype으로 설정된 Bean은 Singleton 아님!
	public Client client(){
		Client client = new Client();
		client.setHost("host");
		return client;
	}
	
	@Bean
	@Scope("singleton")//singleton으로 명시할수 있다.
	public Client2 client2(){
		Client2 client= new Client2();
		client.setHost("host2");
		return client;
	}
}
