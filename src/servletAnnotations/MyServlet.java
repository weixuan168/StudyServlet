package servletAnnotations;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by Xuan on 2017/3/30.
 * <p>
 * Servlet接口中方法注释
 * <p>
 * 接口中的方法默认public abstract
 * abstract（抽象）方法是只有声明，没有实现的
 */
public interface MyServlet {
    /**
     *生命周期方法，由服务器调用
     *在servlet对象创建后马上执行，并只执行一次
     */
    void init(ServletConfig servletConfig) throws ServletException;

    /**
     *由程序员调用
     *获取servlet配置信息
     */
    ServletConfig getServletConfig();

    /**
     *生命周期方法，由服务器调用
     *每次处理请求都会调用service方法，即可多次调用
     */
    void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException;

    /**
     *由程序员调用
     *获取servlet信息
     */
    String getServletInfo();

    /**
     *生命周期方法，由服务器调用
     *在servlet对象被销毁前调用，只执行一次
     */
    void destroy();
}
