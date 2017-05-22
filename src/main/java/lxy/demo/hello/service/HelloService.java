package lxy.demo.hello.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@EnableAsync
public class HelloService {

	@Async
	public String sayHello(){
		
		try {
			Thread.sleep(5000);
			System.out.println("#############");
			return "sleep 5s" ;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			return "InterruptedException 5s" ;

		}
	}
	
}
