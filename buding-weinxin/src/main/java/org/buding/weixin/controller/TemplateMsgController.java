package org.buding.weixin.controller;

import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.buding.weixin.model.LinkCustomer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    //曹红林 olrN51FoZwcHtTnhKFVKBms-LWO4
    //Godric olrN51Kx9apJ6jbo3_OTekiiMJNA
    private final String OPEN_ID="oJzCD55ZOaSCmdyua5rRaTpysUUA";

    private final String TEMP_ID="GIXQWewxlSmAhALcIAr9Ca5ulhXvhpz0H32aBqVvk44";

    @PostMapping("/sendMsg")
    public String sendTmpMsg(@PathVariable String appid,
                             @RequestBody LinkCustomer linkCustomer){

        WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
            .toUser(OPEN_ID)
            .templateId(TEMP_ID)
           // .url(url)
            .build();
        String linkTypeDesc="专车接送";
        if(linkCustomer.getLinkType().equals("2")){
            linkTypeDesc="自驾";
        }
        templateMessage.addData(new WxMpTemplateData("keyword1",linkCustomer.getCustomerName(),"#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword2",linkCustomer.getMobile(),"#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword3",linkTypeDesc,"#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword4",linkCustomer.getLinkNum().toString(),"#173177"));
        templateMessage.addData(new WxMpTemplateData("keyword5",linkCustomer.getLinkDate(),"#173177"));

        try {
          return   wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }
}
