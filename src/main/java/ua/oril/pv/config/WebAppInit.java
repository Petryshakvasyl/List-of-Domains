package ua.oril.pv.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by pevsat on 01.09.2016.
 */
public class WebAppInit implements WebApplicationInitializer {

    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppConfig.class);

        ServletRegistration.Dynamic dispacher = servletContext.addServlet("SpringDispatcher",
                new DispatcherServlet(applicationContext));
        dispacher.setLoadOnStartup(1);
        dispacher.addMapping("/");
    }
}
