package com.controller.plant;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Plant;
import com.service.user.plant.PlantService;
import com.service.user.plant.impl.PlantServiceImpl;

/**
 * Servlet implementation class PlantServlet
 */
@WebServlet("/PlantServlet")
public class PlantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private PlantService ps=new PlantServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//获得客户端传递的参数值
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("add".equals(op)) {
			//调用增加的方法
			savePlant(req,resp);
		}else if("show".equals(op)) {
			//显示所有数据的方法
			show(req,resp);
		}else if("findByid".equals(op)) {
			//通过id来查询的方法
			findByid(req,resp);
		}else if("update".equals(op)) {
		
			//通过id来查询的方法
			update(req,resp);
		}else if("delById".equals(op)) {
			//删除
			delById(req,resp);
		}else if("delAll".equals(op)) {
			//批量删除
			delAll(req,resp);
		}
		
		
	}
	
	
	

	//批量删除
	private void delAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String plateIds = req.getParameter("plateIds");
		
		PrintWriter out = resp.getWriter();
		boolean isOk = ps.delAll(plateIds);
		if(isOk) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
		
	}

	//删除
	private void delById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int plateId=Integer.parseInt(req.getParameter("plateId"));
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		boolean isOk = ps.delById(plateId);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
		
	}


	
	//修改
	  private void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
			
		//设置响应的文件类型
			resp.setContentType("application/json;charset=UTF-8");
			//获得数据
			int plateId=Integer.parseInt(req.getParameter("plateId"));
			String plateTitle=req.getParameter("plateTitle");
			String plateMessage=req.getParameter("plateMessage");
			int isEnable=Integer.parseInt(req.getParameter("isEnable"));
		//	System.out.println(plateTitle);
			
			Plant plant=new Plant(plateId,plateTitle,plateMessage,isEnable);
			
			boolean isOk=ps.update(plant);
			PrintWriter pw=resp.getWriter();
			if(isOk) {
				pw.write("{\"result\":\"true\"}");
			}else {
				pw.write("{\"result\":\"false\"}");
			}
			pw.flush();
			
			
			
			
		
	}

		//通过id来显示
		private void findByid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			////设置字符编码
			req.setCharacterEncoding("UTF-8");
			//获取页面数据
			int plateId=Integer.parseInt(req.getParameter("plateId"));
			Plant isOk=ps.findByid(plateId);
			
			if(isOk!=null) {
				
				req.getSession().setAttribute("find", isOk);
				req.getRequestDispatcher("server/plant-edit.jsp").forward(req,resp);
			}
		
	}

		//页面显示
		protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//设置字符编码
			req.setCharacterEncoding("UTF-8");
			List<Plant> list=ps.show();
			req.setAttribute("list", list);
			
			
			//页面跳转
			req.getRequestDispatcher("server/plant-list.jsp").forward(req, resp);
			
		}
	
	
	
	
	
	//增加
	protected void savePlant(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//设置响应的文件类型
		resp.setContentType("application/json;charset=UTF-8");
		//获得数据
		String plateTitle=req.getParameter("plateTitle");
		String plateMessage=req.getParameter("plateMessage");
		
		//System.out.println(plateMessage);
		
		Plant plant=new Plant(plateTitle,plateMessage);
		boolean isOk=ps.savePlant(plant);
		PrintWriter pw=resp.getWriter();
		if(isOk) {
			pw.write("{\"result\":\"true\"}");
		}else {
			pw.write("{\"result\":\"false\"}");
		}
		pw.flush();
	
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
