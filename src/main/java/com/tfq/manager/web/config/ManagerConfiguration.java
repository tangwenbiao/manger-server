package com.tfq.manager.web.config;

import com.tfq.manager.web.config.intercept.TokenValidInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/14 21:22
 */
@ComponentScan({"com.tfq.manager.service"})
public class ManagerConfiguration extends WebMvcConfigurationSupport {

  @Autowired
  private TokenValidInterceptor loginInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 注册自定义拦截器，添加拦截路径和排除拦截路径
    registry.addInterceptor(loginInterceptor) // 添加拦截器
        .addPathPatterns("/**") // 添加拦截路径
        .excludePathPatterns("/swagger*/**")//过滤路径
        .excludePathPatterns("/webjars/**")
        .excludePathPatterns("/api/v1/doc/**")
        .excludePathPatterns("/login/login")
        .excludePathPatterns("/error/**")
        .excludePathPatterns("/test/**");
    super.addInterceptors(registry);
  }

  private CorsConfiguration corsConfig() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.addAllowedOrigin("*");
    corsConfiguration.addAllowedHeader("*");
    corsConfiguration.addAllowedMethod("*");
    corsConfiguration.setAllowCredentials(true);
    return corsConfiguration;
  }

  @Bean
  public CorsFilter corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig());
    return new CorsFilter(source);
  }

}
