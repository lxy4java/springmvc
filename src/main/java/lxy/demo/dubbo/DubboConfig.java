package lxy.demo.dubbo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Dubbo配置类
 * 
 * @author lance
 * @version 2015年8月25日
 * @see DubboConfig
 * @since
 */
@Configuration
@PropertySource(value = {"classpath:dubbo.properties"})
public class DubboConfig extends DefaultDubboConfig {
	
}