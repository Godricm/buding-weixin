package org.buding.weixin.config;

import org.buding.weixin.utils.JsonUtils;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 21:35
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
@ConfigurationProperties(prefix = "wx.mp")
public class WxMpProperties {

    private List<MpConfig> configs;

    @Data
    public static class MpConfig{
        /**
         * 设置微信公众号的appid
         */
        private String appId;
        /**
         * 设置微信公众号的app secret
         */
        private String secret;
        /**
         * 设置微信公众号的token
         */
        private String token;
        /**
         * 设置微信公众号的EncodingAESKey
         */
        private String aesKey;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
