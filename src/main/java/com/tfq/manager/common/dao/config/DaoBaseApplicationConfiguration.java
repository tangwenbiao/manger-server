package com.tfq.manager.common.dao.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DataSourceConfiguration.class, PageHelperConfiguration.class})
public class DaoBaseApplicationConfiguration {

}
