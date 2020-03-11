package id.mbingweb.mvc.mybatis.jsp.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * AppInitializer
 * - File ini pengganti web.xml, fungsinya yaitu menginisialisasi konfigurasi-konfigurasi yg ada.
 * - Dalam kasus ini semua konfigurasi yg ada pada package `id.mbingweb.mvc.mybatis.jsp.config`
 * 
 * @author fqodry
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context = 
                new AnnotationConfigWebApplicationContext();
        context.setConfigLocation("id.mbingweb.mvc.mybatis.jsp.config");
        
        servletContext.addListener(new ContextLoaderListener(context));
        
        ServletRegistration.Dynamic dispatcher = servletContext
                .addServlet("dispatcher", new DispatcherServlet(context));
        
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
