package com.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages={"com.niitmrt.shoppingbackend.model"})
@EnableTransactionManagement
public class HibernateConfig {

	// Change the below based on the DBMS you choose
		private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/shopping";
		private final static String DATABASE_DRIVER = "org.h2.Driver";
		private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
		private final static String DATABASE_USERNAME = "sa";
		private final static String DATABASE_PASSWORD = "";
	
	
		// dataSource bean will be available
		@Bean("dataSource")
		public DataSource getDataSource() {
			
			BasicDataSource dataSource = new BasicDataSource();
			
			System.out.println(" test1 ");
			// Providing the database connection information
			dataSource.setDriverClassName(DATABASE_DRIVER);
			dataSource.setUrl(DATABASE_URL);
			dataSource.setUsername(DATABASE_USERNAME);
			dataSource.setPassword(DATABASE_PASSWORD);
					
			System.out.println(" test2 ");
			return dataSource;
			
		}
		
		// sessionFactory bean will be available
		
		@Bean
		public SessionFactory getSessionFactory(DataSource dataSource) {
			
			System.out.println(" test3 ");
			LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
			
			builder.addProperties(getHibernateProperties());
			builder.scanPackages("com.niitmrt.shoppingbackend.model");
			System.out.println(" test4 ");
			return builder.buildSessionFactory();
			
		}

		
		
		// A  ll the hibernate properties will be returned in this method	
		private Properties getHibernateProperties() {
			
			
			System.out.println(" test5 ");
			Properties properties = new Properties();
			
			
			properties.put("hibernate.dialect", DATABASE_DIALECT);		
			properties.put("hibernate.show_sql", "true");
			properties.put("hibernate.format_sql", "true");
			
			properties.put("hibernate.hbm2ddl.auto", "update");
			
			System.out.println(" test6 ");
			return properties;
		}
		
		// transactionManager bean
		@Bean
		public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
			System.out.println(" test7 ");
			HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
			System.out.println(" test8 ");
			return transactionManager;
		}
		
		
}
