package lxy.demo.dubbo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

public abstract class DefaultDubboConfig {
	/**
	 * dubbo服务注册地址
	 */
	private static final String REGISTRY_ADDRESS = "dubbo.registry.address";

	/**
	 * dubbo应用名称
	 */
	private static final String APPLICATION_NAME = "dubbo.application.name";

	/**
	 * dubbo服务负责人
	 */
	private static final String APPLICATION_OWNER = "dubbo.application.owner";

	/**
	 * 服务协议端口号
	 */
	private static final String PROTOCOL_PORT = "dubbo.protocol.port";

	/**
	 * 服务协议名
	 */
	private static final String PROTOCOL_NAME = "dubbo.protocol.name";

	/**
	 * 服务协议端口号
	 */
	private static final String DEFAULT_PROTOCOL_PORT = "20880";

	/**
	 * 服务协议名
	 */
	private static final String DEFAULT_PROTOCOL_NAME = "dubbo";

	/**
	 * 服务扫描路径
	 */
	private static final String DEFAULT_PACKAGE_NAME = "lxy.demo";

	/**
	 * 环境变量
	 */
	@Autowired
	protected Environment env;

	/**
	 * Description: 生成AnnotationBean
	 * 
	 * @return AnnotationBean
	 * @see
	 */
	@Bean
	public static AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage(DEFAULT_PACKAGE_NAME);
		return annotationBean;
	}

	/**
	 * Description: 生成applicationConfig
	 * 
	 * @return ApplicationConfig
	 * @see
	 */
	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName(env.getProperty(APPLICATION_NAME));
		applicationConfig.setOwner(env.getProperty(APPLICATION_OWNER));
		return applicationConfig;
	}

	/**
	 * Description: 生成registryConfig
	 * 
	 * @return registryConfig
	 * @see
	 */
	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig = new RegistryConfig();
		registryConfig.setAddress(env.getProperty(REGISTRY_ADDRESS));
		return registryConfig;
	}

	/**
	 * Description: 生成protocolConfig
	 * 
	 * @return protocolConfig
	 * @see
	 */
	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig = new ProtocolConfig(env.getProperty(PROTOCOL_NAME, DEFAULT_PROTOCOL_NAME));
		protocolConfig.setPort(Integer.parseInt(env.getProperty(PROTOCOL_PORT, DEFAULT_PROTOCOL_PORT)));
		return protocolConfig;
	}
}