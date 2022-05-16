package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Serendipity-li
 * @Date: 2022/5/13 - 05 - 13 - 16:21
 */
@Data
@Component
@ConfigurationProperties(prefix = "logging.pattern")
public class PatternProperties {

    private String dateformat;
}
