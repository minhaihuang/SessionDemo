package minhaihuang.cookieDemo.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建一个web的util类，方便使用
 * @author 黄帅哥
 *
 */
public class WebUtil {

	/**
	 * 获得某个特定的cookie的内容
	 * @param cookies
	 * @param cookieName
	 * @return
	 */
	public static String getCookieValue(Cookie[] cookies,String cookieName){
		
		//如果cookies等于空，直接返回空
		if(cookies==null){
			return null;
		}
		//遍历所有的cookie
		for(Cookie cookie:cookies){
			if(cookie.getName().equals(cookieName)){
				return cookie.getValue();//返回值
			}
		}
		
		return null;
	}
	
	public static String getString(HttpServletResponse response,int count) throws IOException{
		//用来存储返回的字符串
		List<String> list=new ArrayList<String>();
		
		int width=30*4;
		int height=30;
		//设置图片的宽度与高度
		BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
		
		//获得画笔
		Graphics g=bi.getGraphics();
		//设置背景颜色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		//绘制边框
		g.setColor(Color.BLACK);
		g.drawRect(0,0, width-1, height-1);
		
		//设置字体，往框内输入验证吗
		String msg="QWERTYUIOPASDFGHJKLZXCVBNM";
		
		//设置字体格式
		g.setColor(Color.RED);
		g.setFont(new Font("宋体",Font.BOLD,18));
		
		//获得随机数
		for(int i=0;i<count;i++){
		Random d=new Random();
		int index=d.nextInt(msg.length());
		String ch=msg.charAt(index)+"";
		g.drawString(ch,5+width/4*i,20);
		//加入字符串
		list.add(ch);
		}
		
		g.setColor(Color.BLACK);
		//设置随机干扰线
		for(int j=0;j<30;j++){
		Random r=new Random();
		int x1=r.nextInt(width);
		int y1=r.nextInt(height);
		int x2=x1+r.nextInt(15);
		int y2=y1+r.nextInt(15);
		g.drawLine(x1, y1, x2, y2);
		}
		//将图片输出到浏览器
		ImageIO.write(bi, "jpg", response.getOutputStream());
		
		StringBuilder data=new StringBuilder();
		for(int k=0;k<list.size();k++){
			data.append(list.get(k));
		}
		
		return data.toString();
	}
}
