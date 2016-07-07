package com.uacity.web.controller;

import com.uacity.web.common.util.WeChatClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.PrintWriter;

/**
 * Created by eegijmc on 7/7/2016.
 */
@Controller
@RequestMapping(value="wechat")
public class VerifyController {

    @RequestMapping(value = "service.do", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public void validate(PrintWriter out, String signature, Long timestamp, String nonce, String echostr) {
        if (StringUtils.isNotBlank(signature) && timestamp != null && StringUtils.isNotBlank(nonce) && StringUtils.isNotBlank(echostr)) {
            if (WeChatClient.validate(signature, timestamp, nonce)) {
                out.write(echostr);
            }
        }
    }

}
