package cn.kejt.apigateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 过滤器,
 * @implNote 在主类启动之后,才生效
 */
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器的类型,决定了在请求的哪个生命周期进行过滤
     * @return
     */
    @Override
    public String filterType() {
        // pre 表示 请求被路由之前执行
        return "pre";
    }

    /**
     * 过滤器的执行顺序,当请求在一个阶段中存在多个过滤器时,定义执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器<code>是否需要</code>被执行.实际中可以利用该方法来指定过滤器的有效范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            // 不进入路由
            ctx.setSendZuulResponse(false);
            // 返回 401 错误
            ctx.setResponseStatusCode(401);
            // optional
            ctx.setResponseBody("被过滤器中断了,可添加错误描述");
            return null;
        }
        log.info("access token ok");
        return null;
    }

}