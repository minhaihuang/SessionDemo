package minhaihuang.sessionDemo.basic;
/**
 * 模拟用户登录的功能
 */
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	//创建一个map用来存储用户的用户名的密码
	private Map<String,User> userMap;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userMap=new HashMap<String,User>();
		userMap.put("hhm", new User("hhm","123"));
		userMap.put("hhm02", new User("hhm02","123"));
		userMap.put("hhm03", new User("hhm03","123"));
		userMap.put("hhm04", new User("hhm04","123"));
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			//获取用户名和密码
			String userName=request.getParameter("userName");
			String passWord=request.getParameter("passWord");
			
			System.out.println(userName);
			System.out.println(passWord);
			User user=userMap.get(userName);
			if(user!=null){
				if(user.getPassWord().equals(passWord)){
					HttpSession session=request.getSession();
					session.setAttribute("user", user);
					
					System.out.println(123456);
					response.sendRedirect("/SessionDemo/succ.jsp");
					
					return;
				}
				
				request.setAttribute("message", "用户名或密码错误");
				request.getRequestDispatcher("/Login.jsp").forward(request, response);
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
