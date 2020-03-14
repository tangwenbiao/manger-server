package com.tfq.manager.web.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/14 22:52
 */
@Data
public class LoginRequestVO {

  @JsonProperty("username")
  private String userName;

  @JsonProperty("password")
  private String password;
}
