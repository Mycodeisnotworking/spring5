package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

import spring.MemberInfoPrinter2;
import spring.MemberPrinter;
import spring.MemberPrinter2;

public class AppCtx2 {
	
	@Bean
	public MemberPrinter printer(){//Bean 한정자: printer
		return new MemberPrinter();
	}
	
	@Bean
	@Qualifier("mprinter")
	public MemberPrinter printer2(){//Bean 한정자: mprinter(qualifier에 따름)
		return new MemberPrinter();
	}
	
	@Bean
	public MemberPrinter2 infoPrinter(){//Bean 한정자: infoPrinter
		MemberInfoPrinter2 infoPrinter = new MemberInfoPrinter2();
		return infoPrinter;
	}
}
