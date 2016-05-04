package lxy.demo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
	
	@Hello(sayHello = "xxxx")
	@RequestMapping("/hello")
	public String hello() {

		return "hello";
	}

}
