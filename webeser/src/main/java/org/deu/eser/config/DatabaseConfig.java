package org.deu.eser.config;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.deu.eser.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class DatabaseConfig {
	@Autowired
	private Environment environment;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		final LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		final EclipseLinkJpaVendorAdapter vendorAdapter = new EclipseLinkJpaVendorAdapter();
		vendorAdapter.setGenerateDdl(true);
		vendorAdapter.setShowSql(false);
		factory.setJpaVendorAdapter(vendorAdapter);
		factory.setDataSource(dataSource());
		factory.setJpaProperties(jpaProperties());
		return factory;
	}

	@Bean
	public DataSource dataSource() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/eser_db");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}

	@Bean
	public Properties jpaProperties() {
		final Properties properties = new Properties();
		properties.setProperty("eclipselink.weaving", "false");
		properties.setProperty("exclude-unlisted-classes", "false");
		return properties;
	}

	@Bean
	public UserDetailsService userService() {
		return new UserService();
	}

	@Bean
	public EmbeddedServletContainerFactory tomcat() {
		TomcatEmbeddedServletContainerFactory tomcat;
		tomcat = new TomcatEmbeddedServletContainerFactory();
		tomcat.setPort(environment.getProperty("server.port", Integer.class));
		tomcat.setSessionTimeout(1000, TimeUnit.MINUTES);
		return tomcat;
	}
}
