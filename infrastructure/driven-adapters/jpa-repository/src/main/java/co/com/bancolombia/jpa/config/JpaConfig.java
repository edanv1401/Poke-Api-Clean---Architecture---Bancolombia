package co.com.bancolombia.jpa.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories
public class JpaConfig {

  @Bean
  public DBSecret dbSecret(@Value("${spring.datasource.url}") String url, @Value("${spring.datasource.username}") String username,
                           @Value("${spring.datasource.password}") String password) {
    return new DBSecret(url, username, password);
  }

  @Bean
  public DataSource datasource(DBSecret secret, @Value("${spring.datasource.driver-class-name}") String driverClass) {
    HikariConfig config = new HikariConfig();
    config.setJdbcUrl(secret.getUrl());
    config.setUsername(secret.getUsername());
    config.setPassword(secret.getPassword());
    config.setDriverClassName(driverClass);
    return new HikariDataSource(config);
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(
      DataSource dataSource,
      @Value("${spring.jpa.database-platform}") String dialect,
      @Value("${spring.jpa.hibernate.ddl-auto}") String ddlAuto) {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan("co.com.bancolombia.jpa");

    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);

    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", dialect);
    properties.setProperty("hibernate.ddl-auto", ddlAuto);
    properties.setProperty("hibernate.show-sql", "true");
    em.setJpaProperties(properties);

    return em;
  }
}
