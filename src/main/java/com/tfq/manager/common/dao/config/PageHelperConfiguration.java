package com.tfq.manager.common.dao.config;

import com.github.pagehelper.PageHelper;
import java.util.Properties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class PageHelperConfiguration {

  @Bean
  public PageHelper pageHelper() {
    PageHelper pageHelper = new PageHelper();
    Properties p = new Properties();
    p.setProperty("offsetAsPageNum", "true");
//    p.setProperty("rowBoundsWithCount", "true");
    p.setProperty("reasonable", "true");
    //通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
    p.setProperty("pageSizeZero", "true");
    pageHelper.setProperties(p);
    //log.info("设置PageHelper的全局配置；配置如下：{}", p);
    ;
    return pageHelper;
  }

//  @Bean(name = "pageInterceptor")
//  public PageInterceptor pageInterceptor(){
//    PageInterceptor pageInterceptor = new PageInterceptor();
//    Properties p = new Properties();
//    p.setProperty("offsetAsPageNum", "true");
////    p.setProperty("rowBoundsWithCount", "true");
//    p.setProperty("reasonable", "true");
//    //通过设置pageSize=0或者RowBounds.limit = 0就会查询出全部的结果。
//    p.setProperty("pageSizeZero", "true");
//    pageInterceptor.setProperties(p);
//    log.info("加载分页配置拦截器pageInterceptor；配置如下：{}",p);
//    return pageInterceptor;
//  }
}
