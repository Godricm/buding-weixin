package org.buding.weixin.handler;

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
 * \* Time: 12:59
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class UnsubscribeHandler extends  AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        String openId=wxMpXmlMessage.getFromUser();
        this.logger.info("取消关注用户 openId："+openId);
        //TODO 可以更新本地数据库为取消状态
        
        return null;
    }
}
