package com.mj;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class BeanConfig {

	@Bean(name = "datasource")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@ConfigurationProperties("spring.datasource")
	public HikariDataSource dataSource(DataSourceProperties properties) {
		return properties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
	}

//	@Bean(name = "datasource")
//	public DataSource dataSourcejndi() throws NamingException {
//		JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
//		bean.setJndiName("java:/cmsds");
//		bean.setProxyInterface(DataSource.class);
//		bean.setLookupOnStartup(false);
//		bean.afterPropertiesSet();
//		return (DataSource) bean.getObject();
//	}

}
