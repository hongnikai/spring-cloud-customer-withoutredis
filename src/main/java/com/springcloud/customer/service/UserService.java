package com.springcloud.customer.service;


import com.springcloud.customer.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String,Object> selectAllUser();

    List<Map<String,Object>> selectPriceInnerJoinPriceOrder(Map<String, Object> map);

    void insertUsers(List list);

    User findUserByAccountAndPassword(String username, String password);

    User findUserByUserId(String id);

}
