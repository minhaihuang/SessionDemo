package minhaihuang.sessionDemo.oneTimeCheckNumber;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import minhaihuang.cookieDemo.util.WebUtil;

public class GetNumberServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String data=WebUtil.getString(response, 4);
		HttpSession session=request.getSession();
		
		session.setAttribute("data", data);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
