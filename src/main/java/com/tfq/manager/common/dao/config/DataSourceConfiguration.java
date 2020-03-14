package com.tfq.manager.common.dao.config;

import static com.tfq.manager.common.dao.config.DruidDataSourceUtil.getDruidDataSource;

import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
@MapperScan(basePackages = "com.**.dao.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfiguration {

  private static final String MAPPER_LOCATION = "classpath*:mybatis/sql-map/**/*.xml";

  @Value("${mysql.url:127.0.0.1}")
  private String url;

  @Value("${mysql.username:root}")
  private String user;

  @Value("${mysql.password:root123}")
  private String password;

  @Value("${jdbc.mysql.driver:com.mysql.jdbc.Driver}")
  private String driverClass;

  @Bean(name = "dataSource")
  @Primary
  public DataSource dataSource() {
    return getDruidDataSource(driverClass, url, user, password);
  }

  @Bean(name = "transactionManager")
  @Primary
  public DataSourceTransactionManager transactionManager() {
    return new DataSourceTransactionManager(dataSource());
  }

  @Bean(name = "sqlSessionFactory")
  @Primary
  public SqlSessionFactory sqlSessionFactory(
      @Qualifier("dataSource") DataSource dataSource)
      throws Exception {
    final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
        .getResources(MAPPER_LOCATION));
    return sessionFactory.getObject();
  }
}
