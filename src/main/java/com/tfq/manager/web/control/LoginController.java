package com.tfq.manager.web.control;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/14 19:35
 */
@Api(value = "登录相关API", tags = {"登录相关API"})
@RestController
@RequestMapping("login")
@Slf4j
public class LoginController {

  @ApiOperation(value = "登录")
  @RequestMapping(value = "login", method = RequestMethod.POST)
  public void toLogin(@RequestBody String name) {
    System.out.println(name);
  }

  @ApiOperation(value = "获取权限信息")
  @RequestMapping(value = "getAuth", method = RequestMethod.POST)
  public void getAuth(@RequestBody String name) {
    System.out.println(name);
  }

}
