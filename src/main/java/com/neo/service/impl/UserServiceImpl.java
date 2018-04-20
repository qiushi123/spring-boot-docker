package com.neo.service.impl;

import com.neo.model.User;
import com.neo.repository.UserRepository;
import com.neo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 设置redis（对user设置了redis缓存）
@CacheConfig(cacheNames = "userlist")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Cacheable //列表redis缓存
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(key = "#p0")
    public User findUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    @CachePut(key = "#p0.id")//新增或修改时要执行这个，用来同步更新缓存
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    @CachePut(key = "#p0.id")//新增或修改时要执行这个，用来同步更新缓存
    public void edit(User user) {
        userRepository.save(user);
    }

    @Override
    @CacheEvict(key = "#p0")//删除
    public void delete(long id) {
        userRepository.deleteById(id);
    }
}


