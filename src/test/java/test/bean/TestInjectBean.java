package test.bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lxy.demo.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class TestInjectBean {

	@Value("${db1.jdbc.driver}")
	private String driver;

	@Test
	public void driver() {
		System.out.println(driver);
	}
}
