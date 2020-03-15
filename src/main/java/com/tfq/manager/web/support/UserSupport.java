package com.tfq.manager.web.support;

import org.springframework.stereotype.Component;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/15 11:21
 */
public class UserSupport {

  private static final ThreadLocal<Integer> USER_CONTEXT = new ThreadLocal<>();

  public static Integer get() {
    if (USER_CONTEXT.get() == null) {
      throw new RuntimeException("根据token未找到用户!");
    }
    return USER_CONTEXT.get();
  }

  public static void set(Integer userId) {
    USER_CONTEXT.set(userId);
  }

}
