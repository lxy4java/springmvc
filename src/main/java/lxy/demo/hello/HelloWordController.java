package lxy.demo.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

	@Value("${db1.jdbc.driver}")
	private String driver;

	@Hello(sayHello = "xxxx")
	@RequestMapping("/hello")
	public String hello() {

		return "hello: " + driver;
	}

}
