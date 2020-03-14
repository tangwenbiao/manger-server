package com.tfq.manager.common.dao.mybatis;

import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;


@Slf4j
public class JavaTypeResolverCustomImpl extends JavaTypeResolverDefaultImpl {


  public JavaTypeResolverCustomImpl() {
    //转换成LocalDataTime
    super();
    typeMap.put(Types.TIME, new JdbcTypeInformation("TIME", //$NON-NLS-1$
        new FullyQualifiedJavaType(LocalTime.class.getName())));
    typeMap.put(Types.TIMESTAMP, new JdbcTypeInformation("TIMESTAMP", //$NON-NLS-1$
        new FullyQualifiedJavaType(LocalDateTime.class.getName())));
    typeMap.put(Types.DATE, new JdbcTypeInformation("DATE", //$NON-NLS-1$
        new FullyQualifiedJavaType(LocalDate.class.getName())));
  }

//  @Override
//  public FullyQualifiedJavaType calculateJavaType(IntrospectedColumn introspectedColumn) {
//    FullyQualifiedJavaType fullyQualifiedJavaType = super.calculateJavaType(introspectedColumn);
//    log.info(introspectedColumn.getActualColumnName() + " ：" + introspectedColumn.getJdbcTypeName()
//        + " =======> " + fullyQualifiedJavaType.getFullyQualifiedName());
//    return fullyQualifiedJavaType;
//  }
}
