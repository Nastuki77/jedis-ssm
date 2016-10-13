package org.jedis.config;

import org.jedis.utils.ClientConstants;
import org.springframework.context.annotation.Configuration;


import java.util.Map;

@Configuration
public class MyAppConfig {
	public static Map<String, String> APP_CONFIGS = ClientConstants.getAppConfigs();

/*	@Bean
	public DataSource dataSource() {
		return DsUtils.getDataSource(APP_CONFIGS.get("driverClass"),
				APP_CONFIGS.get("url"), APP_CONFIGS.get("username"),
				APP_CONFIGS.get("password"));
	}*/
}
