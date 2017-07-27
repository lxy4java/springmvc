package lxy.demo.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lxy.demo.transaction.bean.Reward;
import lxy.demo.transaction.service.RewardServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:spring-mvc.xml" })
public class TestTransaction {
	
	/****
	 * myisam 不支持事务,一定要切成innodb
	 * 
	 * **/
	
	@Autowired
	RewardServiceImpl service;

	@Test
	public void test() {
		Reward rw = new Reward();
		rw.setArticle_id(111);
		rw.setArticle_title("哈哈");
		rw.setFrom_id(33);
		rw.setFrom_name("哈哈");
		rw.setMoney(new BigDecimal("30"));
		rw.setUser_id(33);
		rw.setUser_name("呵呵");
		rw.setReason("好");
		service.save(rw);
	}

}
