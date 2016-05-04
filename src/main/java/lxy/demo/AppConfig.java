package lxy.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lxy.demo.hello.HelloAspect;

@Configuration
public class AppConfig {

	@Bean
	HelloAspect helloAspect() {
		return new HelloAspect();
	}

}
