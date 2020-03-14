package com.tfq.manager;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/14 19:43
 */
@SpringBootApplication
@EnableSwagger2Doc
public class ManagerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ManagerApplication.class);
  }

}
