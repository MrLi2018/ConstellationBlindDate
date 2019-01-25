package mainRun.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by IntelliJ IDEA.
 * Author: 栗旭辰
 * Date: 2019/1/21
 * Time: 14:18
 */
@Configuration
public class CorsConfiguration extends WebMvcConfigurerAdapter {
    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        logger.info("*****************************全局跨域配置开始*******************************");
        registry.addMapping("/**")    //匹配了所有的URL
                .allowedHeaders("*")  //允许跨域请求包含任意的头信息
                .allowedMethods("*")  //允许外域发起请求任意HTTP Method
                .allowedOrigins("http://localhost:8081"); //允许所有的外域发起跨域请求
    }
}
