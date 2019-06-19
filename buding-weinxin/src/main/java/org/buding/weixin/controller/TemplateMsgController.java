package org.buding.weixin.controller;

import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.web.bind.annotation.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/19 0019
 * \* Time: 20:12
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@AllArgsConstructor
@RestController
@RequestMapping("/wx/templatemsg/{appid}")
public class TemplateMsgController {

    private final WxMpService wxMpService;

    @PostMapping("/sendMsg")
    public String sendTmpMsg(@PathVariable String appid,
                             @RequestParam(value = "openid",required = false) String openid,
                             @RequestParam(value = "tmpid",required = false) String tmpid,
                             @RequestParam(value = "url",required = false) String url){
        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
            .toUser(openid)
            .templateId(tmpid)
            .url(url)
            .build();
        templateMessage.addData(new WxMpTemplateData("keyword1","godric","#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword2","13761089640","#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword3","3","#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword4","2019-09-28","#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword5","自驾","#173177"));

        try {
          return   wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }
}
