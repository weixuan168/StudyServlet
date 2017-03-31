package util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Xuan on 2017/3/30.
 */
public class VerifyCode {
    private int width = 100;//设置图片缓冲区的宽
    private int height = 35;//设置图片缓冲区的高
    private Random r = new Random();//生成随机数字
    private String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑"};//创建一个字体数组
    private Color bgColor = new Color(200, 200, 200);//创建图片的白色背景
    private String codes = "1234567890zxcvbnmasdfghjklqwertyuiop";//可供选择的随机文字
    private String text;//在图片上生成的文本

    /**
     * 创建图片缓冲区
     */
    public BufferedImage getImage() {
        BufferedImage image = createImage();//调用创建图片缓冲区方法
        Graphics g = image.getGraphics();//得到绘制环境
        StringBuilder sb = new StringBuilder();//用来装载生成的验证码文本
        /*
         *循环生成4个字符
         */
        for (int i = 0; i < 4; i++) {
            String str = randomChar() + "";//调用产生随机字符的方法
            sb.append(str); //将生成的随机字符加到sb后面
            g.setFont(randomFont());//调用产生随机字体的方法
            g.setColor(randomColor());//调用产生随机颜色的方法
            g.drawString(str, width / 4*i, height-5);//在图片中绘制文本
        }
        this.text = sb.toString();//把生成的字符串赋给文本
        drawLine(image);//调用添加干扰线的方法对图片中的文本进行干扰
        return image;
    }

    private BufferedImage createImage() {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(bgColor);
        g.fillRect(0, 0, width, height);
        return image;
    }

    public char randomChar() {
        int index = r.nextInt(codes.length());
        char y = codes.charAt(index);
        return y;
    }

    public Font randomFont() {
        int index = r.nextInt(fontNames.length);
        int style=r.nextInt(4);//设置字体样式，0表示无样式，1表示粗体，2表示斜体，3表示粗体加斜体
        int size=r.nextInt(4)+24;//设置字体大小，范围在24到27之间
        return new Font(fontNames[index], style, size);
    }

    public Color randomColor() {
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int blue = r.nextInt(150);
        return new Color(red, green, blue);
    }

    public void drawLine(BufferedImage image) {
        //循环3次，画3条干扰线
        Graphics g = image.getGraphics();
        for(int i=0;i<3;i++) {
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(width);
            int y2 = r.nextInt(height);//得到所要划线的起点和终点坐标
            g.setColor(Color.blue);//设置干扰线的颜色
            g.drawLine(x1, y1, x2, y2);
        }
    }

    /*
     *返回验证码图片上的文本
     * 在getImage()方法之后调用
     */
    public String getText() {
        return this.text;
    }

    /*
     *保存图片到指定的输出流
     */
    public static void output(BufferedImage image, OutputStream out) throws IOException {
        ImageIO.write(image, "JPEG", out);
    }
}

