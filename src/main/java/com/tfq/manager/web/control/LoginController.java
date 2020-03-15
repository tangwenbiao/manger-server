package com.tfq.manager.web.control;

import com.tfq.manager.web.model.request.LoginRequestVO;
import com.tfq.manager.web.model.response.LoginResponseVO;
import com.tfq.manager.web.model.response.UserInfoResponseVO;
import com.tfq.manager.web.support.TokenSupport;
import com.tfq.manager.web.support.UserSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private TokenSupport tokenSupport;

  @ApiOperation(value = "登录")
  @RequestMapping(value = "login", method = RequestMethod.POST)
  public LoginResponseVO toLogin(@RequestBody LoginRequestVO loginRequestVO) {
    //验证用户信息
    int userId=10;
    //生成token保存
    String token = tokenSupport.generateToken(userId);
    //返回验证信息
    LoginResponseVO loginResponseVO=new LoginResponseVO();
    loginResponseVO.setToken(token);
    return loginResponseVO;
  }

  @ApiOperation(value = "获取用户信息")
  @RequestMapping(value = "getUserInfo", method = RequestMethod.POST)
  public UserInfoResponseVO getAuth() {
    UserInfoResponseVO user=new UserInfoResponseVO();
    user.setName("测试");
    user.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    user.setIntroduction("I am a super administrator");
    List<String> roles=new ArrayList<>();
    roles.add("admin");
    user.setRoles(roles);
    return user;
  }

  @ApiOperation(value = "异常信息测试")
  @RequestMapping(value = "toException",method = RequestMethod.POST)
  public String toException(){
    throw new RuntimeException("测试系统异常");
  }

  @ApiOperation(value = "用户登出")
  @RequestMapping(value = "logout", method = RequestMethod.POST)
  public void toLogout(){
    System.out.println(UserSupport.get()+":登出!");
  }
}
