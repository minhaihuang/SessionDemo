package minhaihuang.sessionDemo.oneTimeCheckNumber;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OneTimeCheckNumberLoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//获取验证码
		String checkNumber=request.getParameter("checkNumber");
		System.out.println(checkNumber);
		String data=(String) request.getSession().getAttribute("data");
		System.out.println(data);
		if(checkNumber.equals(data)){//验证码正确，然后的是正常的登陆步骤
			//移除验证码
			request.getSession().removeAttribute("data");
			
			//获取用户名与密码的容器
			Map<String,String> userMap=(HashMap<String,String>)getServletContext().getAttribute("userMap");
			//获取输入的用户名与密码
			String userName=request.getParameter("userName");
			String passWord=request.getParameter("passWord");
			if(userMap.containsKey(userName)){
				String p=userMap.get(userName);
				if(p.equals(passWord)){
					//登陆成功，显示资源页面
					request.getRequestDispatcher("/source.jsp").forward(request, response);
				}else{
					//登陆不成功，设置错误信息，返回登陆页面
					request.getSession().setAttribute("wrongMessage", "用户名或密码错误");
					response.sendRedirect("/SessionDemo/oneTimeCheckNumber.jsp");
				}
			}
		}else{//验证码不正确的操作，重新返回到登陆页面
			request.getSession().removeAttribute("data");
			//设置错误信息
			request.getSession().setAttribute("wrongMessage", "验证码不正确");
			response.sendRedirect("/SessionDemo/oneTimeCheckNumber.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
