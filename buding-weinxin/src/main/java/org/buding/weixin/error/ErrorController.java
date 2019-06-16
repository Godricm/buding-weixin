package org.buding.weixin.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 20:31
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
@RequestMapping("/error")
public class ErrorController {
    @GetMapping(value = "/404")
    public String error404(){
        return "error";
    }

    @GetMapping(value = "/500")
    public String error500() {
        return "error";
    }
}
