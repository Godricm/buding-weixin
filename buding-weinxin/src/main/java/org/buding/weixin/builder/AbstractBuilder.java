package org.buding.weixin.builder;

import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: godric
 * \* Date: 2019/6/15 0015
 * \* Time: 12:49
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public abstract class AbstractBuilder {
    protected Logger logger= LoggerFactory.getLogger(getClass());

    public abstract WxMpXmlOutMessage build(String context, WxMpXmlMessage wxMpXmlMessage, WxMpService service);
}
