package org.buding.weixin.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 12:52
 * \* To change this template use File | Settings | File Templates.
 * \* Description:文本输出形式
 * \
 */
public class TextBuilder extends AbstractBuilder {
    @Override
    public WxMpXmlOutMessage build(String context, WxMpXmlMessage wxMpXmlMessage, WxMpService service) {
        WxMpXmlOutMessage m = WxMpXmlOutMessage.TEXT()
                .content(context)
                .fromUser(wxMpXmlMessage.getToUser())
                .toUser(wxMpXmlMessage.getFromUser())
                .build();
        return m;
    }
}
