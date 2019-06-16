package org.buding.weixin.handler;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.buding.weixin.builder.TextBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 13:42
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class LocationHandler extends AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {

        if(wxMpXmlMessage.getMsgType().equals(WxConsts.XmlMsgType.LOCATION)){
            //TODO 接受用户发送的地理位置
            try {
                String content="感谢反馈，你的地理位置已收到";
                return new TextBuilder().build(content,wxMpXmlMessage,null);
            } catch (Exception e) {
                this.logger.error("位置消息接收处理失败", e);
                return null;
            }
        }
        this.logger.info("上报地理位置，纬度:{},经度：{},精度:{}",wxMpXmlMessage.getLatitude(),wxMpXmlMessage.getLongitude(),String.valueOf(wxMpXmlMessage.getPrecision()));
        //TODO 可以将用户地理位置信息保存本地数据库，以便以后使用

        return null;
    }
}
