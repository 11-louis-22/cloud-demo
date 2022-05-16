package cn.itcast.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


/**
 * @Author: Serendipity-li
 * @Date: 2022/5/14 - 05 - 14 - 13:11
 *
 * 需求：定义全局过滤器，拦截请求，判断请求的参数是否满足下面条件：
 *
 * - 参数中是否有authorization，
 *
 * - authorization参数值是否为admin
 *
 * 如果同时满足则放行，否则拦截
 */
@Component
//@Order(-1)//设置过滤器的执行顺序，值越小，越先执行
public class AuthorizeFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
       /* *
         *  处理当前请求，有必要的话通过{@link GatewayFilterChain}将请求交给下一个过滤器处理
         * @param exchange 请求上下文，里面可以获取Request、Response等信息
         * @param chain 用来把请求委托给下一个过滤器
         * @return {@code Mono<Void>} 返回标示当前过滤器业务结束*/

        // 1.获取请求参数，k：参数名称，v：参数值
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        // 2.获取authorization参数
        String value = queryParams.getFirst("authorization");//从里面取出第一个匹配的，一般选该方法
        //List<String> value = queryParams.get("authorization");从里面取出所有匹配匹配的
        // 3.校验
        if (value.equals("admin")) {
            //放行
            return chain.filter(exchange);//调用filter时，就是从GatewayFilterChain中找到下一个过滤器
        }
        // 4.拦截
        // 4.1.禁止访问，设置状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);//设置为401状态码
        // 4.2.结束处理
        return exchange.getResponse().setComplete();
    }

     /** 许多过滤器的执行顺序，值越小，越先执行
     * @return
     * */
    @Override
    public int getOrder() {
        return -1;
    }
}
