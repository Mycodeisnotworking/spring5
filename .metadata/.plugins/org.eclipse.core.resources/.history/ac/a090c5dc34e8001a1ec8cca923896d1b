package config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import spring.MemberDao;
import spring.MemberPrinter;

@Configuration
@ComponentScan(basePackages={"spring"},
  excludeFilters = @Filter(type=FilterType.REGEX, pattern = "spring\\..*Dao"))
/*
 * @ComponentScan(basePackages={"spring"},
  excludeFilters = @Filter(type=FilterType.ASPECTJ, pattern = "spring.*Dao"))
  ASPECTJ 패턴 사용 시 pom.xml의 dependency에 aspectjweaver 모듈 추가해야됨.
 */
public class AppCtxWithExclude {
	@Bean
	public MemberDao memberDao(){
		return new MemberDao();
	}
	
	@Bean
	@Qualifier("printer")
	public MemberPrinter memberPrinter1(){
		return new MemberPrinter();
	}

}


/*
 * Annotation으로 거를 수도 있음
 * ex)
 * 
 * code1)
 * @Retention(RUNTIME)
 * @Target(TYPE)
 * public @interface NoProduct{}
 * 
 * @Retention(RUNTIME)
 * @Target(TYPE)
 * public @interface ManualBean{}
 * 
 * code2)
 * 
 * @Configuration
 * @ComponentScan(basePackages={"spring", "spring2"},
  excludeFilters = @Filter(type=FilterType.ANNOTATION, classes = {NoProduct.class, ManualBean.class}))
  ~
  
  특정 타입 or 그 하위 타입을 제외할 시
  ASSIGNABLE_TYPE을 filter type으로 사용(여러 class 제외 시 위와 같이 배열 사용)
  @ComponentScan(basePackages={"spring", "spring2"},
  excludeFilters = @Filter(type=FilterType.ASSIGNABLE_TYPE, classes = NoProduct.clas))
  
  필터 여러개 적용할 시에는 
  excludeFilters = {
   @Filter(~~),
   @Filter(~~),
   ...
   }
   식으로 적용
 * */
 */