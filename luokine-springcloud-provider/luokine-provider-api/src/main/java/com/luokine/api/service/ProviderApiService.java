package com.luokine.api.service;

import com.luokine.api.vo.SysUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/provider")
public interface ProviderApiService {

    @GetMapping("/hello")
    public String providerHello();

    @GetMapping("/getList")
    public List<SysUser> getList();
}
