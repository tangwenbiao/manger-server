package com.tfq.manager.web.advice;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author: wangwei
 * @description: 返回值统一封装
 * @date：19-5-8 下午2:39
 */
@Slf4j
@ControllerAdvice(basePackages = {"com.tfq.manager.web.control"})
public class ResponseAdvice implements ResponseBodyAdvice {

  private final Integer SYSTEM_BUSY = -1;
  private final Integer SYSTEM_SUCCESS = 20000;
  private final Integer TOKEN_ERROR = 4002;
  @Autowired
  private Gson gson;

  @Override
  public boolean supports(MethodParameter methodParameter, Class aClass) {
    return true;
  }

  @Override
  public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
      Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
    BaseResponse.BaseResponseBuilder baseResponseBuilder = BaseResponse.builder();
    baseResponseBuilder.code(SYSTEM_SUCCESS);
    baseResponseBuilder.message("");
    if(o==null){
      return baseResponseBuilder.build();
    }
    baseResponseBuilder.data(o);
    return baseResponseBuilder.build();
  }
}
