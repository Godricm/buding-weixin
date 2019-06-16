package org.buding.weixin.handler;

import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.buding.weixin.builder.TextBuilder;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 12:40
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Component
public class SubscribeHandler extends  AbstractHandler {
    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMpXmlMessage, Map<String, Object> map, WxMpService wxMpService, WxSessionManager wxSessionManager) throws WxErrorException {
        this.logger.info("新用户 openId:"+wxMpXmlMessage.getFromUser());
        //获取微信用户基本信息
        try {
            WxMpUser userWxInfo=wxMpService.getUserService().userInfo(wxMpXmlMessage.getFromUser(),null);
            if(userWxInfo!=null){
                //TODO 可以添加关注用户到本地数据库
            }

        }catch (WxErrorException e){
            if (e.getError().getErrorCode() == 48001) {
                this.logger.info("该公众号没有获取用户信息权限！");
            }
        }

        WxMpXmlOutMessage responseResult=null;
        try {
                responseResult=this.handleSpecial(wxMpXmlMessage);
        } catch (Exception e) {
           this.logger.error(e.getMessage(),e);
        }

        if(responseResult!=null){
            return responseResult;
        }

        try {
            return new TextBuilder().build("感谢关注", wxMpXmlMessage, wxMpService);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
      * @param 微信消息
     * @return
     */
    private WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage)throws Exception{
        return  null;
    }
}
