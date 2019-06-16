package org.buding.weixin.handler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.buding.weixin.builder.TextBuilder;
import org.buding.weixin.utils.JsonUtils;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 13:32
 * \* To change this template use File | Settings | File Templates.
 * \* Description: 消息处理
 * \
 */
@Component
public class MsgHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {

        if(!wxMpXmlMessage.getMsgType().equals(WxConsts.XmlMsgType.EVENT)){
            //可以选择将消息保存到本地

        }

        try {
            if(StringUtils.startsWithAny(wxMpXmlMessage.getContent(),"你好","客服")&& wxMpService.getKefuService().kfOnlineList()
                    .getKfOnlineList().size() > 0){
            return WxMpXmlOutMessage.TRANSFER_CUSTOMER_SERVICE().fromUser(wxMpXmlMessage.getToUser()).toUser(wxMpXmlMessage.getFromUser()).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //TODO 组装回复消息
        String content="收到回复内容："+ JsonUtils.toJson(wxMpXmlMessage);
        return new TextBuilder().build(content,wxMpXmlMessage,wxMpService);
    }
}
