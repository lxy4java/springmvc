package lxy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import lxy.demo.hello.HelloAspect;

@Configuration
@ImportResource("classpath:dubbo.xml")
public class AppConfig {

	@Bean
	HelloAspect helloAspect() {
		return new HelloAspect();
	}

}
