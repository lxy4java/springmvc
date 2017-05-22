package lxy.demo.hello;

import java.util.concurrent.Callable;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lxy.demo.hello.service.HelloService;

@RestController
public class HelloWordController {

	//@Value("${db1.jdbc.driver}")
	private String driver;

	@Inject
	private HelloService service;
	
	//@Hello(sayHello = "xxxx")
	@RequestMapping("/hello")
	public String hello() {

		return "hello: " + driver;
	}

	@RequestMapping("/async")
	public Callable<String> async() {
		service.sayHello();
		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				Thread.sleep(5000);
				return "async";
			}
			
		};
	}

}
