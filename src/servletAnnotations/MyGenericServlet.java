package servletAnnotations;

import servletAnnotations.MyServletConfig;

import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Xuan on 2017/3/30.
 * <p>
 * GenericServlet类方法注释
 * <p>
 * abstract类可以包含抽象方法，也可以包含普通方法
 * abstract类不可以被实例化，但可以创建该类型的引用变量（向上转型）
 */
public abstract class MyGenericServlet implements MyServlet, MyServletConfig {
    private transient ServletConfig config;

    /**
     * 实现Servlet接口的方法
     */
    public void destroy() {
    }

    /**
     * 实现ServletConfig接口的方法
     * @param name（参数名）
     * @return 参数值
     */
    public String getInitParameter(String name) {
        return this.getServletConfig().getInitParameter(name);
    }

    /**
     *实现ServletConfig接口的方法
     */
    public Enumeration<String> getInitParameterNames() {
        return this.getServletConfig().getInitParameterNames();
    }

    /**
     *实现Servlet接口的方法
     */
    public ServletConfig getServletConfig() {
        return this.config;
    }

    /**
     *实现ServletConfig接口的方法
     */
    public ServletContext getServletContext() {
        return this.getServletConfig().getServletContext();
    }

    /**
     *实现Servlet接口的方法
     */
    public String getServletInfo() {
        return "";
    }

    /**
     * 实现Servlet接口的方法
     * @param config
     * @throws ServletException
     */
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        this.init();
    }

    /**
     * 自定义的init()方法，由程序员调用
     * @throws ServletException
     */
    public void init() throws ServletException {
    }

    /**
     * 打印日志信息
     * @param msg
     */
    public void log(String msg) {
        this.getServletContext().log(this.getServletName() + ": " + msg);
    }

    public void log(String message, Throwable t) {
        this.getServletContext().log(this.getServletName() + ": " + message, t);
    }

    /**
     * 实现Servlet接口的方法
     * 为抽象方法，必须由子类实现
     * @param var1
     * @param var2
     * @throws ServletException
     * @throws IOException
     */
    public abstract void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException;

    /**
     * 实现ServletConfig接口的方法
     */
    public String getServletName() {
        return this.config.getServletName();
    }
}
