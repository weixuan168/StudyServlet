package servlet;

import util.VerifyCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Xuan on 2017/3/30.
 */
public class VerifyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    /*
     *1.生成图片
     * 2.保存图片上的文本到session域
     * 3. 把图片响应给客户端
     */
        VerifyCode vc = new VerifyCode();
        BufferedImage image = vc.getImage();
        request.getSession().setAttribute("text", vc.getText());
        VerifyCode.output(image, response.getOutputStream());
    }

}
