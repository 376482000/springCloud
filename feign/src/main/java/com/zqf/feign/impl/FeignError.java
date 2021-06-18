package com.zqf.feign.impl;

import com.zqf.feign.FeignProviderClient;
import com.zqf.model.Student;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeignProviderClient {
    @Override
    public Collection<Student> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护中////////";
    }
}
