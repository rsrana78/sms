package com.ayp.sms.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support
    .AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author rana
 */

public class AppInitializer implements WebApplicationInitializer {

    public void onStartup (ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx =  new AnnotationConfigWebApplicationContext();
        ctx.register(AppConfig.class);
        ctx.setServletContext(servletContext);
        ctx.refresh();
        DispatcherServlet dispatcherServlet = new DispatcherServlet(ctx);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
        servlet.addMapping("/");
        servlet.setLoadOnStartup(1);
        servlet.setMultipartConfig(new MultipartConfigElement("/tmp", 1024*1024*5, 1024*1024*5*5, 1024*1024));
    }
}
