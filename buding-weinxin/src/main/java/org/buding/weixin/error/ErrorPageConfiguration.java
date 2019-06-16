package org.buding.weixin.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2019/6/15 0015
 * \* Time: 20:33
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class ErrorPageConfiguration implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        registry.addErrorPages(
                new ErrorPage(HttpStatus.NOT_FOUND,"/error/404"),
                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error/500")
        );

    }
}
