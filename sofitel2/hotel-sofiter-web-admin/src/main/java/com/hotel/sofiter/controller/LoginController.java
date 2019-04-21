package com.hotel.sofiter.controller;

import com.hotel.sofiter.pojo.UserPo;
import com.hotel.sofiter.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


@Api(tags = "登录对象接口")
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;


    /**
     * 验证码
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @RequestMapping(value = "/Check",method = RequestMethod.GET)
    @ResponseBody
    public void Check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.实例化一个带缓冲区的图像数据对象
        //第一个参数为图像的宽度,第二个参数为高度,第三个参数为图像的颜色类型--三原色
        int width = 110;
        int height = 50;
        BufferedImage bImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.通过图像数据对象获取画笔
        Graphics graphiscs = bImage.getGraphics();
        //3.设置画笔颜色
        graphiscs.setColor(Color.GRAY);
        //4.使用画笔填充背景颜色
        //x轴的开始,y轴的开始,x轴的结束,y轴的结束
        graphiscs.fillRect(0,0,width,height);
        //5.给画笔换颜色
        graphiscs.setColor(Color.BLUE);
        //6.设置字体
        graphiscs.setFont(new Font("宋体",Font.BOLD,20));
        //7.绘制验证码
        Random ran = new Random();
        int code = 0;
        //保存验证码
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i < 4;i++){
            code = ran.nextInt(10);
            sb.append(code+"");
            //给图像绘制内容--内容,x轴,y轴
            graphiscs.drawString(code+"",15+20*i,35);
        }
        //1.存储到DBCenter
        // DBCenter.code = sb.toString();

        //2.存放在ServletContext中--作用域是服务器级别
        //getServletContext().setAttribute("code",sb.toString());

        //3.存放在session中
        request.getSession().setAttribute("code",sb.toString());

        //8.添加干扰线
        graphiscs.setColor(Color.GREEN);
        for (int i = 0; i < 10;i++){
            graphiscs.drawLine(ran.nextInt(width),ran.nextInt(height),ran.nextInt(width),ran.nextInt(height));
        }

        //9.把绘制好图像发送给前端
        ImageIO.write(bImage,"jpg",response.getOutputStream());

    }


    @RequestMapping(value = "/UserServlet",method = RequestMethod.POST)
    @ResponseBody
    public void UserServlet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        /*String remember = request.getParameter("remember");
        //从前端获取用户输入的code
        String code = request.getParameter("code");
        //从session中获取code
        String newCode = (String) request.getSession().getAttribute("code");*/
        /*User user = new User(username,password,code,newCode,remember);*/
        /* userService.setUser(user);
        String s = userService.UserLogin(request,response);
        System.out.println(s);*/

        /*if (!newCode.equals(code)){
           response.getWriter().write("fail");
        }else if ("sa".equals(username) && "123".equals(password)){
           response.getWriter().write("success");
        }*/

        UserPo userPo = new UserPo();
        userPo.setUserName(username);
        userPo.setPassword(password);
        UserPo user = userService.selectLogin(userPo);
        System.out.println(user);
        if (username.equals(user.getUserName()) && password.equals(user.getPassword())){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("fail");
        }


        /*if ("success".equals(s)){
            response.getWriter().write("success");
        }else {
            response.getWriter().write("fail");
        }*/

    }




    /*@RequestMapping(value = "/UserServlet",method = RequestMethod.GET)
    @ResponseBody
    public void UserServlet
            (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String ajax = request.getParameter("ajax");
        String cookieValue = CookieUtils.getCookieValue(request, "UserInfo");

        //login.html页面发送的ajax请求
        if ("login".equals(ajax)){
            if (cookieValue != null && !"".equals(cookieValue)){
                //不等于null则说明保存有cookie,由于cookie保存了账号和密码,所以根据分割符分别获取
                String[] split = cookieValue.split(",");
                //密码不能解密,只能获取账号
                String username = split[0];
                String password = split[1];

                //根据账号获取完整的User信息
                User user = new User(username,password);

                //调用JSON工具包把user信息转换为JSON数据
                String json = JSON.toJSONString(user);

                System.out.println(user);
                System.out.println(json);
                //发送打包好的JSON到前端ajax处理
                response.getWriter().write(json);
                return;
            }
        }

    }*/


}
