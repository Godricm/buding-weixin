package org.buding.weixin.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 20:30
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ImageBuilder extends AbstractBuilder {
    @Override
    public WxMpXmlOutMessage build(String context, WxMpXmlMessage wxMpXmlMessage, WxMpService service) {
        WxMpXmlOutMessage m = WxMpXmlOutMessage.IMAGE().mediaId(context).fromUser(wxMpXmlMessage.getToUser()).toUser(wxMpXmlMessage.getFromUser()).build();
        return m;
    }
}
