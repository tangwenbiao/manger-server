package com.tfq.manager.web.support;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/15 11:05
 */
@Component
public class TokenSupport {

  private static final ConcurrentHashMap<String,Integer> TOKEN_USER=new ConcurrentHashMap<>();

  public Integer getUserId(String token){
    return TOKEN_USER.get(token);
  }

  public boolean containsToken(String token){
    return TOKEN_USER.containsKey(token);
  }

  public String generateToken(Integer userId){
    String token;
    if(userId==10){
      token="a1111111";
    }
    token="acccc";
    TOKEN_USER.put(token,userId);
    return token;
  }

}
