package com.jackzeng.activiti.rest.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
  @PropertySource(value = "classpath:db.properties", ignoreResourceNotFound = true),
  @PropertySource(value = "classpath:engine.properties", ignoreResourceNotFound = true)
})
@ComponentScan(basePackages = {"com.jackzeng.activiti.rest.conf","com.jackzeng.mutiltenant"})
@ImportResource({"classpath:activiti-context-cfg.xml","classpath:crc-mutiltenant-cfg.xml"})
public class ApplicationConfiguration {
  
}
