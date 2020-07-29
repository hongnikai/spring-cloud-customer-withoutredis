package com.springcloud.customer.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name= "spring-cloud-provider")
public interface ProviderDao {

    @RequestMapping(value = "/testMessage")
    String hello();

}
