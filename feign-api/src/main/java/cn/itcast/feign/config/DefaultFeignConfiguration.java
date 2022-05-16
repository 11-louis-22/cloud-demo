package cn.itcast.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @Author: Serendipity-li
 * @Date: 2022/5/14 - 05 - 14 - 0:44
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){

        return Logger.Level.BASIC;
    }
}
