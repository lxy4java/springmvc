package lxy.demo.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HelloJob {

	
	@Scheduled(cron="0/5 * * * * ?")
	public void work(){
		System.out.println("hello~~~~~~~~~~~~~`");
	}
	
}
