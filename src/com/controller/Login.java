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

	//����һ�������û���ҵ�������
	private UserService us=new UserServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// ���ñ���
		req.setCharacterEncoding("UTF-8");
		// ��� op����ֵ
		String lo = req.getParameter("lo");
		
		if("login".equals(lo)) {
		//�˳���¼
			login(req,resp);
		}
		else if("loginOut".equals(lo)) {
		//�˳���¼
			loginOut(req,resp);
		}

	}
		
		
		
	//��¼
	protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
		//���ñ���
		req.setCharacterEncoding("UTF-8");
		//���ҳ������
		String userId=req.getParameter("userId");
		String userPsw=req.getParameter("userPsw");
		//����ҵ��㷽��������֤
		boolean isOk= us.verification(userId, userPsw);
		
		//������֤�����ʵ��ҳ����ת
		if(isOk) {
			//��תweb-inf/server/index.html
			//req.getRequestDispatcher("/WEB-INF/server/index.html").forward(req, resp);
			PlantService ps=new PlantServiceImpl();
			List<Plant> plist=ps.show();
			req.getSession().setAttribute("plist", plist);
			
			
			req.getSession().setAttribute("userId", userId);
			resp.sendRedirect("Index");
		}else {
			//���»ص���¼ҳ��
			resp.sendRedirect("login.html");
		}
	}

	
	
	
	//�˳���¼
	protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		// ���������session�е��û���
				req.getSession().removeAttribute("userId");
				resp.sendRedirect("login.html");
		
		
	}
	
	
	
	
	
}
