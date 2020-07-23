package demo.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author CBeann
 * @create 2020-07-05 16:41
 */
@WebFilter(filterName="HelloFilter",urlPatterns="/*")
public class HelloFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("doFilter----------------before-------------");
        chain.doFilter(request, response);
        System.out.println("doFilter----------------after-------------");

    }

    @Override
    public void destroy() {

    }
}
