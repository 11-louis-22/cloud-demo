package cn.itcast.feign.client;

import cn.itcast.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author: Serendipity-li
 * @Date: 2022/5/13 - 05 - 13 - 21:54
 */
@FeignClient("userservice")
public interface UserClient {

    @GetMapping("/user/{id}")
    User get(@PathVariable("id") long id);

}
