package cn.bdqn.s.Servlets;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by sunbin on 2017/6/23.
 */
public class Filter2 implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        System.out.println("进入。。。。");
       req.setCharacterEncoding("UTF-8");
       resp.setCharacterEncoding("UTF-8");
            chain.doFilter(req, resp);
            System.out.println("退出");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
