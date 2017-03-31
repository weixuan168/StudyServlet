package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by Xuan on 2017/3/30.
 */
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String code = request.getParameter("code");
        if (!code.equalsIgnoreCase((String)request.getSession().getAttribute("text"))) {
            request.setAttribute("msg","验证码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("aaa")) {
            Cookie cookie = new Cookie("uname", username);
//          Cookie的maxAge:指Cookie的最大生命，即Cookie可保存在客户端中的最大时长，以秒为单位。
//          maxAge>0:浏览器会把Cookie保存到客户端硬盘上，有效时长为maxAge的值决定，例如:cookie.setMaxAge(60)表示这个Cookie会被浏览器保存到硬盘上60秒。
//          maxAge<0:Cookie只会在浏览器内存中存在，当用户关闭浏览器时浏览器进程结束，同时Cookie也就死亡了。
//          maxAge=0:浏览器会马上删除这个Cookie
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);

            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            try {
                response.sendRedirect("succ1.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            request.setAttribute("msg", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
