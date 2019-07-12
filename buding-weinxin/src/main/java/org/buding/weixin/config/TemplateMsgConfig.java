package org.buding.weixin.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: STO
 * \* Date: 2019/7/12
 * \* Time: 9:52
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
public class TemplateMsgConfig {
    @Value("${wx.templateMsg.touser}")
    private String toUser;

    @Value("${wx.templateMsg.tmpid}")
    private String tmpId;
}
