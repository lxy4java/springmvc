package lxy.demo;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lxy.demo.hello.HelloAspect;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableAspectJAutoProxy
public class AppConfig {

	@Bean
	HelloAspect helloAspect() {
		return new HelloAspect();
	}

	/**********
	 * 
	 * 使用的是 dbcp 的basicDatasource
	 * Datasource 要交给spring 管理，否则事务不生效
	 **/
	@Bean
	DataSource dataSource() {
		BasicDataSource connectionPoolDataSource = new BasicDataSource();
		connectionPoolDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		connectionPoolDataSource
				.setUrl("jdbc:mysql://localhost:3306/huodong?useUnicode=true&amp;characterEncoding=UTF-8");
		connectionPoolDataSource.setUsername("root");
		connectionPoolDataSource.setPassword("654321");
		connectionPoolDataSource.setValidationQuery("select now()");
		connectionPoolDataSource.setMaxTotal(16);
		/**
		 * mysql 数据库 自动 提交
		 */
		// connectionPoolDataSource.setDefaultAutoCommit(true);
		connectionPoolDataSource.setDefaultTransactionIsolation(1);
		return connectionPoolDataSource;
	}

	@Bean
	JdbcTemplate jdbcTemplate() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	PlatformTransactionManager transactionManager() {

		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());
		return transactionManager;
	}

}
