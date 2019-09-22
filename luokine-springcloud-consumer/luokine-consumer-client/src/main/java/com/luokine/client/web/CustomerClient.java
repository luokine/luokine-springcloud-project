package com.luokine.client.web;

import com.luokine.service.controller.CustomerService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: tiantziquan
 * @create: 2019-06-14 16:16
 */
@FeignClient(CustomerClientPKG.OPEN_SERVICE)
public interface CustomerClient extends CustomerService {
}
