package com.mentoria.integraInventories.configurations;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import feign.Request;
import feign.Request.Options;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.mentoria.integraInventories.gateways.outputs"})
public class FeignConfiguration {
  @Value("${feign.connectionTimeout:60000}")
  private int feignConectionTimeout;

  @Value("${feign.readTimeout:60000}")
  private int feignReadTimeout;

  @Bean
  public Request.Options requestOptions(){
    return new Options(
        feignConectionTimeout, MILLISECONDS, feignReadTimeout, MILLISECONDS, true);
  }
}
