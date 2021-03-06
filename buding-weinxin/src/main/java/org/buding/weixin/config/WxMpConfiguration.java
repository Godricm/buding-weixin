package org.buding.weixin.config;

import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import org.buding.weixin.handler.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

import static me.chanjar.weixin.common.api.WxConsts.EventType.SUBSCRIBE;
import static me.chanjar.weixin.common.api.WxConsts.EventType.UNSUBSCRIBE;
import static me.chanjar.weixin.common.api.WxConsts.MenuButtonType.*;
import static me.chanjar.weixin.common.api.WxConsts.XmlMsgType.EVENT;
import static me.chanjar.weixin.mp.constant.WxMpEventConstants.CustomerService.KF_CREATE_SESSION;
import static me.chanjar.weixin.mp.constant.WxMpEventConstants.CustomerService.KF_SWITCH_SESSION;
import static me.chanjar.weixin.mp.constant.WxMpEventConstants.POI_CHECK_NOTIFY;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 21:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@AllArgsConstructor
@Configuration
@EnableConfigurationProperties(WxMpProperties.class)
public class WxMpConfiguration {

    private final LogHandler logHandler;
    private final NullHandler nullHandler;
    private final KfSessionHandler kfSessionHandler;
    private final StoreCheckNotifyHandler storeCheckNotifyHandler;
    private final LocationHandler locationHandler;
    private final MenuHandler menuHandler;
    private final MsgHandler msgHandler;
    private final UnsubscribeHandler unsubscribeHandler;
    private final SubscribeHandler subscribeHandler;
    private final ScanHandler scanHandler;
    private final WxMpProperties properties;

    @Bean
    public WxMpService wxMpService(){
        final List<WxMpProperties.MpConfig> configs=this.properties.getConfigs();
        if(configs==null){

            throw new RuntimeException("添加下相关配置，注意别配错了！");
        }
        WxMpService service=new WxMpServiceImpl();
        service.setMultiConfigStorages(configs.stream().map(a->{
            WxMpInMemoryConfigStorage configStorage = new WxMpInMemoryConfigStorage();
            configStorage.setAppId(a.getAppId());
            configStorage.setSecret(a.getSecret());
            configStorage.setToken(a.getToken());
            configStorage.setAesKey(a.getAesKey());
            return configStorage;
        }).collect(Collectors.toMap(WxMpInMemoryConfigStorage::getAppId,a->a,(o,n)->o)));

        return service;
    }

    @Bean
    public WxMpMessageRouter messageRouter(WxMpService wxMpService){
        final WxMpMessageRouter newRouter=new WxMpMessageRouter(wxMpService);

        //记录所有事件的日志（异步执行）
        newRouter.rule().handler(this.logHandler).next();


        //接受客服会话管理事件
        newRouter.rule().async(false).msgType(EVENT).event(KF_CREATE_SESSION)
                .handler(this.kfSessionHandler).end();
        newRouter.rule().async(false).msgType(EVENT).event(KF_CREATE_SESSION)
                .handler(this.kfSessionHandler).end();
        newRouter.rule().async(false).msgType(EVENT).event(KF_SWITCH_SESSION)
                .handler(this.kfSessionHandler).end();

        //门店审核事件
        newRouter.rule().async(false).msgType(EVENT).event(POI_CHECK_NOTIFY).handler(this.storeCheckNotifyHandler).end();

        //自定义菜单事件
        newRouter.rule().async(false).msgType(EVENT).event(CLICK).handler(this.menuHandler).end();

        //点击菜单链接事件
        newRouter.rule().async(false).msgType(EVENT).event(VIEW).handler(this.nullHandler).end();

        //关注事件
        newRouter.rule().async(false).msgType(EVENT).event(SUBSCRIBE).handler(this.subscribeHandler).end();

        //取消关注事件
        newRouter.rule().async(false).msgType(EVENT).event(UNSUBSCRIBE).handler(this.unsubscribeHandler).end();

        // 上报地理位置事件
        newRouter.rule().async(false).msgType(EVENT).event(WxConsts.EventType.LOCATION).handler(this.locationHandler).end();

        // 接收地理位置消息
        newRouter.rule().async(false).msgType(WxConsts.XmlMsgType.LOCATION).handler(this.locationHandler).end();

        // 扫码事件
        newRouter.rule().async(false).msgType(EVENT).event(WxConsts.EventType.SCAN).handler(this.scanHandler).end();

        // 默认
        newRouter.rule().async(false).handler(this.msgHandler).end();
        return newRouter;
    }
}
