package com.huangbin.gsarts.filters;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by HUANGBIN on 2016/3/1 0001.
 */

@Component("sessionFilter")
@WebFilter
@Order(1)
public class SessionFilter implements Filter {
    Logger logger = LoggerFactory.getLogger(SessionFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("过滤器----------------------init");
    }

    /**
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Headers", "accept,content-type");
        response.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("过滤器----------------------destroy");
    }
}

