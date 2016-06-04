package minhaihuang.sessionDemo.oneTimeCheckNumber;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HHMComServlet extends HttpServlet {

	Map<String,String> userMap;
	/**
	 * 初始化数据
	 */
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		 userMap=new HashMap<String,String>();
		 userMap.put("hhm", "123");
		 userMap.put("hhm01", "123");
		 userMap.put("hhm02", "123");
		 userMap.put("hhm03", "123");
		 userMap.put("hhm04", "123");
		 
		 getServletContext().setAttribute("userMap", userMap);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/oneTimeCheckNumber.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
