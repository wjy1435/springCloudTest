package com.example.demo.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter(filterName = "ayUserFilter",urlPatterns = "/*")
public class AyUserFilter implements Filter {


    public boolean isLoggable(LogRecord record) {
        return false;
    }
    @Override
    public void init(FilterConfig FilterConfig) throws ServletException {
        System.out.println("----------------------->>>>>>>  init");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException,ServletException {
              System.out.println("-------------->>>>>>>> doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    public void destroy(){

        System.out.println("-------------->>>>>>>>> destory");
    }

}
