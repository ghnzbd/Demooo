package demo.config;

import demo.intercepter.HelloIntercepter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author CBeann
 * @create 2020-02-06 23:42
 */
//@Configuration
//@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    public WebMvcConfig(){
        System.out.println("WebMvcConfig .............");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("addInterceptors....");
        //创建自定义的拦截器
        HelloIntercepter helloIntercepter = new HelloIntercepter();
        //添加拦截器
        registry.addInterceptor(helloIntercepter)
                //添加需要拦截的路径
                .addPathPatterns("/*");
    }


}
