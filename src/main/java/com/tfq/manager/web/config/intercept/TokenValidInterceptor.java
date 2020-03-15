package com.tfq.manager.web.config.intercept;

import com.tfq.manager.web.support.TokenSupport;
import com.tfq.manager.web.support.UserSupport;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author: TangFenQi
 * @description: 权限验证拦截器
 * @date：2020/3/14 21:56
 */
@Component
public class TokenValidInterceptor implements HandlerInterceptor {

  private final String TOKEN_NAME="X-Token";

  @Autowired
  private TokenSupport tokenSupport;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    //获取token
    String token = request.getHeader(TOKEN_NAME);
    //获取路径
    if(!tokenSupport.containsToken(token)){
        throw new  RuntimeException("该用户无权限访问!");
    }
    UserSupport.set(tokenSupport.getUserId(token));
    //判断是否有权限
    //添加到当前线程变量中
    return true;
  }

}
