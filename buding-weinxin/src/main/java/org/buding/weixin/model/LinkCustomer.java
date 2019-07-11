package org.buding.weixin.model;

import lombok.Data;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/7/10 0010
 * \* Time: 22:13
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Data
public class LinkCustomer {
    private String customerName;
    private String mobile;
    private Integer linkNum;
    private String linkDate;
    private String linkType;
}
