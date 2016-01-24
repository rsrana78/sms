package com.ayp.sms.config;
/**
 * @author rana
 */

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.google.common.base.Preconditions;
import static com.ayp.sms.util.AppConstants.*;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:application.properties" })
@ComponentScan(basePackages = { "com.ayp.sms" })
@EnableJpaRepositories(basePackages = { "com.ayp.sms" })
public class DatabaseConfig {

    @Autowired
    private Environment env;

    public DatabaseConfig() {
        super();
    }

    @Bean
    public EntityManagerFactory entityManagerFactory(){
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setShowSql(Boolean.TRUE);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.ayp.sms");
        factory.setDataSource(dataSource());
        factory.afterPropertiesSet();
        factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
        return factory.getObject();
    }

    @Bean
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(Preconditions.checkNotNull(env.getProperty(JDBC_DRIVER_CLASS_NAME)));
        dataSource.setUrl(Preconditions.checkNotNull(env.getProperty(JDBC_URL)));
        dataSource.setUsername(Preconditions.checkNotNull(env.getProperty(JDBC_USERNAME)));
        dataSource.setPassword(Preconditions.checkNotNull(env.getProperty(JDBC_PASSWORD)));
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(){

    	EntityManagerFactory factory = entityManagerFactory();
        return new JpaTransactionManager(factory);
    }

    final Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(HIBERNATE_DIALECT, env.getProperty(HIBERNATE_DIALECT));
        hibernateProperties.setProperty(HIBERNATE_SHOW_SQL, env.getProperty(HIBERNATE_SHOW_SQL));
        return hibernateProperties;
    }

}