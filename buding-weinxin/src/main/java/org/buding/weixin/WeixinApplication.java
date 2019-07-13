package org.buding.weixin;

import org.buding.weixin.config.TemplateMsgConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;

@SpringBootApplication
public class WeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinApplication.class, args);
    }

    @Bean
    public TemplateMsgConfig getTemplateMsgConfig(){
        return new TemplateMsgConfig();
    }
}
