package lxy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@PropertySource(value = "classpath:db.properties")
public class AppConfig {

//	@Bean
//	HelloAspect helloAspect() {
//		return new HelloAspect();
//	}
	
	/***
	 * 和  PropertySource 注解一起解析 properties 文件 并 可以被@value 读取
	 * */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

}
