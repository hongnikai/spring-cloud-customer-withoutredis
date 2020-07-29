package com.springcloud.customer.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.springcloud.customer.entity.User;
import org.springframework.web.client.RestTemplate;

public class UserCommand extends HystrixCommand<User> {

    private RestTemplate restTemplate;
    private long id;

    public UserCommand(Setter setter, RestTemplate restTemplate, Long id) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("UserGroup")));
        this.restTemplate = restTemplate;
        this.id = id;
    }

    @Override
    protected User run() throws Exception {
        return restTemplate.getForObject("http://spring-cloud-provider/hello3?id=333",User.class,id);

    }

    @Override
    protected String getCacheKey() {
        return String.valueOf(id);
    }


//    @Override
//    protected User getFallback() {
//        Throwable executionException = getExecutionException();
//        System.out.println(executionException.getMessage());
//        return new User("11111","xinsheng");
//
//
//    }





}
