package com.tfq.manager.web.advice;
import com.tfq.manager.web.advice.model.BaseResponse;
import com.tfq.manager.web.advice.model.BaseResponse.BaseResponseBuilder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: wangwei
 * @description:
 * @date：19-5-10 上午11:08
 */
@Slf4j
@ControllerAdvice(basePackages = "com.tfq.manager.web.control")
public class ExceptionAdvice {

  private final Integer SYSTEM_ERR=40000;

  @ExceptionHandler
  @ResponseBody
  public BaseResponse handlerException(Exception e, HttpServletRequest request,
      HttpServletResponse response) {
    log.error("System Biz Error", e);
    BaseResponseBuilder builder = BaseResponse.builder();
    builder.code(SYSTEM_ERR);
    builder.data(null);
    builder.message(e.getMessage());
    return builder.build();
  }
}
