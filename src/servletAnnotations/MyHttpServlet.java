package servletAnnotations;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by Xuan on 2017/3/30.
 * <p>
 * 跟Http协议相关的Servlet类
 * 需重写doGet()和doPost()方法
 */
public class MyHttpServlet extends MyGenericServlet {
    @Override
    public void service(ServletRequest var1, ServletResponse var2) throws ServletException, IOException {

    }
}
