package lxy.demo;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import lxy.demo.hello.HelloAspect;
import lxy.demo.utils.EncrypUtil;

@Configuration
public class AppConfig {

	@Bean
	HelloAspect helloAspect() {
		return new HelloAspect();
	}

	private static final Properties PROPERTIES = new Properties();

	private static String privateKey;

	static {
		InputStream is = AppConfig.class.getResourceAsStream("/db.properties");

		try {
			PROPERTIES.load(is);
			privateKey = Files.readAllLines(new File(PROPERTIES.getProperty("rsa.private.key")).toPath()).get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(PROPERTIES.getProperty("db1.jdbc.driver"));
		basicDataSource.setUrl(PROPERTIES.getProperty("db1.jdbc.url"));
		basicDataSource.setUsername(EncrypUtil.decrypt(PROPERTIES.getProperty("db1.jdbc.username"), privateKey));
		basicDataSource.setPassword(EncrypUtil.decrypt(PROPERTIES.getProperty("db1.jdbc.password"),privateKey));
		basicDataSource.setValidationQuery(PROPERTIES.getProperty("db1.jdbc.validationQuery"));
		basicDataSource.setMaxIdle(16);
		basicDataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		return basicDataSource;
	}

	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(dataSource());
		return template;
	}

}
