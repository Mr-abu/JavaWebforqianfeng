<%@ page import="javax.imageio.ImageIO" %>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.Random" %>
<%@ page import="java.awt.image.BufferedImage" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        response.setHeader("Cache-Control", "no-cache");
        //在内存中创建图像
        int width = 60,height = 20;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = image.getGraphics();
        //设置背景色
        g.setColor(new Color(200,200,200));
        g.fillRect(0,0,width,height);
        //随机产生验证码
        Random rnd = new Random();
        int randNum = rnd.nextInt(8999) + 1000;
        String randStr = String.valueOf(randNum);
        //将验证码存入session
        session.setAttribute("randStr",randStr);
        //将验证码显示在图像中
        g.setColor(Color.black);
        g.setFont(new Font("", Font.PLAIN,20));
        g.drawString(randStr,10,17);
        //随机产生100个随机点
        for(int i=0;i<100;i++){
            int x = rnd.nextInt(width);
            int y = rnd.nextInt(height);
            g.drawOval(x,y,1,1);
        }
        //输出图像到页面
        ImageIO.write(image,"JPEG", response.getOutputStream());
        out.clear();
        out = pageContext.pushBody();
    %>
</body>
</html>
