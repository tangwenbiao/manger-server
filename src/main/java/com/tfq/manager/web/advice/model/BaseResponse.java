package com.tfq.manager.web.advice.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/14 22:15
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseResponse {
  /***
   * 状态值
   */
  @SerializedName("code")
  private Integer code;

  /***
   * message
   */
  @SerializedName("message")
  private String message;

  /***
   * 内容
   */
  @SerializedName("data")
  private Object data;
}
