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
		
		//��ÿͻ��˴��ݵĲ���ֵ
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("add".equals(op)) {
			//�������ӵķ���
			savePlant(req,resp);
		}else if("show".equals(op)) {
			//��ʾ�������ݵķ���
			show(req,resp);
		}else if("findByid".equals(op)) {
			//ͨ��id����ѯ�ķ���
			findByid(req,resp);
		}else if("update".equals(op)) {
		
			//ͨ��id����ѯ�ķ���
			update(req,resp);
		}else if("delById".equals(op)) {
			//ɾ��
			delById(req,resp);
		}else if("delAll".equals(op)) {
			//����ɾ��
			delAll(req,resp);
		}
		
		
	}
	
	
	

	//����ɾ��
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

	//ɾ��
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


	
	//�޸�
	  private void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
			
		//������Ӧ���ļ�����
			resp.setContentType("application/json;charset=UTF-8");
			//�������
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

		//ͨ��id����ʾ
		private void findByid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			////�����ַ�����
			req.setCharacterEncoding("UTF-8");
			//��ȡҳ������
			int plateId=Integer.parseInt(req.getParameter("plateId"));
			Plant isOk=ps.findByid(plateId);
			
			if(isOk!=null) {
				
				req.getSession().setAttribute("find", isOk);
				req.getRequestDispatcher("server/plant-edit.jsp").forward(req,resp);
			}
		
	}

		//ҳ����ʾ
		protected void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			//�����ַ�����
			req.setCharacterEncoding("UTF-8");
			List<Plant> list=ps.show();
			req.setAttribute("list", list);
			
			
			//ҳ����ת
			req.getRequestDispatcher("server/plant-list.jsp").forward(req, resp);
			
		}
	
	
	
	
	
	//����
	protected void savePlant(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//������Ӧ���ļ�����
		resp.setContentType("application/json;charset=UTF-8");
		//�������
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
