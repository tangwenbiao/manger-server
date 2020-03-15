package com.tfq.manager.web.model.response;

import java.util.List;
import lombok.Data;

/**
 * @author: TangFenQi
 * @description:
 * @date：2020/3/15 11:01
 */
@Data
public class UserInfoResponseVO {

  public List<String> roles;//权限信息

  public String introduction; //暂时不知道的什么含义

  public String avatar;//头像的地址

  public String name;//名称

}
