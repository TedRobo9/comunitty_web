package com.uacity.web.controller;

import com.uacity.web.common.util.WeChatClient;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by eegijmc on 7/7/2016.
 */
@Controller
@RequestMapping(value = "wechat")
public class VerifyController {

    @RequestMapping(value = "verify", method = RequestMethod.GET)
    public void validate(PrintWriter out,
                         @RequestParam("signature") String signature,
                         @RequestParam("timestamp") Long timestamp,
                         @RequestParam("nonce") String nonce,
                         @RequestParam("echostr") String echostr) {
        if (StringUtils.isNotBlank(signature) && timestamp != null && StringUtils.isNotBlank(nonce) && StringUtils.isNotBlank(echostr)) {
            if (WeChatClient.validate(signature, timestamp, nonce)) {
                out.write(echostr);
            }
        }
    }

}
