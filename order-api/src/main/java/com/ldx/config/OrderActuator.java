package com.ldx.config;

import com.netflix.hystrix.Hystrix;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderActuator {

    @Bean
    public ServletRegistrationBean getServletRegistrationBean(){

        HystrixMetricsStreamServlet mss = new HystrixMetricsStreamServlet();

        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(mss);

        servletRegistrationBean.setName("servletRegistrationBean");
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.addUrlMappings("/hystrix.stream");
        return servletRegistrationBean;
    }

}
