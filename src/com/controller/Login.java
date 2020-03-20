package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entity.Plant;
import com.entity.category;
import com.service.user.UserService;
import com.service.user.impl.UserServiceImpl;
import com.service.user.plant.PlantService;
import com.service.user.plant.impl.PlantServiceImpl;
@WebServlet("/Login")
public class Login extends HttpServlet {

	//创建一个操作用户的业务类对象
	private UserService us=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 设置编码
		req.setCharacterEncoding("UTF-8");
		// 获得 op参数值
		String lo = req.getParameter("lo");
		
		if("login".equals(lo)) {
		//退出登录
			login(req,resp);
		}
		else if("loginOut".equals(lo)) {
		//退出登录
			loginOut(req,resp);
		}

	}
		
		
		
	//登录
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		//设置编码
		req.setCharacterEncoding("UTF-8");
		//获得页面数据
		String userId=req.getParameter("userId");
		String userPsw=req.getParameter("userPsw");
		//调用业务层方法进行验证
		boolean isOk= us.verification(userId, userPsw);
		
		//更具验证结果，实现页面跳转
		if(isOk) {
			//跳转web-inf/server/index.html
			//req.getRequestDispatcher("/WEB-INF/server/index.html").forward(req, resp);
			PlantService ps=new PlantServiceImpl();
			List<Plant> plist=ps.show();
			req.getSession().setAttribute("plist", plist);
			
			
			req.getSession().setAttribute("userId", userId);
			resp.sendRedirect("Index");
		}else {
			//重新回到登录页面
			resp.sendRedirect("login.html");
		}
	}

	
	
	
	//退出登录
	protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		// 清除保存在session中的用户名
				req.getSession().removeAttribute("userId");
				resp.sendRedirect("login.html");
		
		
	}
	
	
	
	
	
}
