package com.tfq.manager.web.model.response;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/14 22:21
 */
@Data
public class LoginResponseVO {

  public List<String> roles;//权限信息

  public String introduction; //暂时不知道的什么含义

  public String avatar;//头像的地址

  public String name;//名称

}
