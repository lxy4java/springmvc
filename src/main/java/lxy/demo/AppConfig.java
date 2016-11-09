package lxy.demo;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import lxy.demo.hello.HelloAspect;
import lxy.demo.job.CustomTrigger;
import lxy.demo.job.HelloJob;


@Configuration
@PropertySource(value = "classpath:db.properties")
@EnableScheduling
public class AppConfig implements SchedulingConfigurer {

	@Bean
	HelloAspect helloAspect() {
		return new HelloAspect();
	}

	/***
	 * 和 PropertySource 注解一起解析 properties 文件 并 可以被@value 读取
	 */
	@Bean
	public PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
		taskRegistrar.addTriggerTask(new Runnable() {

			@Override
			public void run() {
				helloJob().work();
			}
		}, new CustomTrigger() );
	}

	/***
	 * 
	 * 注意上面例子中使用的@bean(destroyMethod="shutdown")。
	 * 这样是为了确保当Spring应用上下文关闭的时候任务执行者也被正确地关闭。
	 * 实现SchedulingConfigurar接口还允许细粒度控制任务通过ScheduledTaskRegistrar进行登记。
	 */
	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newScheduledThreadPool(100);
	}

	@Bean
	public HelloJob helloJob() {
		return new HelloJob();
	}
}
