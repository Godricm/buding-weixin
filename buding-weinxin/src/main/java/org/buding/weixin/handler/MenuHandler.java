package org.buding.weixin.handler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 13:53
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class MenuHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        String msg=String.format("type:%s,ecent:%s,key:%s",wxMpXmlMessage.getMsgType(),wxMpXmlMessage.getEvent(),wxMpXmlMessage.getEventKey());
        //如果是view
        if(WxConsts.MenuButtonType.VIEW.equals(wxMpXmlMessage.getEvent())){
            return null;
        }

        return WxMpXmlOutMessage.TEXT().content(msg).fromUser(wxMpXmlMessage.getToUser()).toUser(wxMpXmlMessage.getFromUser()).build();
    }
}
