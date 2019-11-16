package com.example.zuulgateway;

import com.example.zuulgateway.security.CurrentUser;
import com.example.zuulgateway.security.UserPrincipal;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import com.example.zuulgateway.UserId;

@Component
public class AuthenticationFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }


    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        Long x = UserId.id;
        ctx.addZuulRequestHeader("uid", String.valueOf(x));
        return null;
    }
}

