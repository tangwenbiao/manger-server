package com.tfq.manager.web.control;

import com.tfq.manager.web.model.request.LoginRequestVO;
import com.tfq.manager.web.model.response.LoginResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
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
  public LoginResponseVO toLogin(@RequestBody LoginRequestVO loginRequestVO) {
    LoginResponseVO loginResponseVO=new LoginResponseVO();
    loginResponseVO.setName("测试");
    loginResponseVO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    loginResponseVO.setIntroduction("I am a super administrator");
    List<String> roles=new ArrayList<>();
    roles.add("admin");
    loginResponseVO.setRoles(roles);
    return loginResponseVO;
  }

  @ApiOperation(value = "获取权限信息")
  @RequestMapping(value = "getAuth", method = RequestMethod.POST)
  public String getAuth(@RequestBody String name) {
    System.out.println(name);
    return name;
  }

}
