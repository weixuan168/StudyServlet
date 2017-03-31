package servletAnnotations;

import javax.servlet.ServletContext;
import java.util.Enumeration;

/**
 * Created by Xuan on 2017/3/30.
 * <p>
 * ServletConfig接口中方法注释
 */
public interface MyServletConfig {

    /**
     * 返回servlet名
     */
    String getServletName();

    /**
     * 返回servlet上下文
     */
    ServletContext getServletContext();

    /**
     * 返回servlet参数值
     */
    String getInitParameter(String var1);

    Enumeration<String> getInitParameterNames();
}
