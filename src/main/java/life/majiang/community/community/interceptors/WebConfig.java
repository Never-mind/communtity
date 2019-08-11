package life.majiang.community.community.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
    拦截器，使用特定功能应用于某些请求，
 */
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //哪些需要经过interceptor处理，对所有路径下的请求全部进行拦截，执行sessionInterceptor，获取cookie
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}
