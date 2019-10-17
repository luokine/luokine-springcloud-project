package com.luokine.service.web;

import com.luokine.service.common.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: tiantziquan
 * @create: 2019-07-19 17:51
 */
@RestController
@RequestMapping("/rabbit")
@Slf4j
public class ChannelsController {

    @Autowired
    private Sender sender;

    @GetMapping("/send")
    public String sendMessage(){
        sender.send();
        return "success";
    }
}
