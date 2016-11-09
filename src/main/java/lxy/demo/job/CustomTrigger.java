package lxy.demo.job;

import java.util.Date;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;



public class CustomTrigger implements Trigger{

	@Override
	public Date nextExecutionTime(TriggerContext context) {
		return null;
	}


}
