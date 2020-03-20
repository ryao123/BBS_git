package com.controller.invitation;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.entity.Invitation;
import com.entity.Plant;
import com.entity.category;
import com.entity.invitation_ans;
import com.service.user.invitation.InvitationService;
import com.service.user.invitation.impl.InvitationServiceImpl;

/**
 * Servlet implementation class InvitationServlet
 */
@WebServlet("/InvitationServlet")
public class InvitationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    InvitationService is=new InvitationServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvitationServlet() {
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
		if("findAll".equals(op)) {
			//调用显示所有数据的方法
			findAll(req,resp);
		}else if("add".equals(op)) {
			//调用增加的方法
			add(req,resp);
		}else if("delById".equals(op)) {
			//调用通过删除id查询的方法
			delById(req,resp);
		}else if("findById".equals(op)) {
			//调用通过id查询的方法
			findById(req,resp);
		}else if("update".equals(op)) {
			//调用通过id查询的方法
			update(req,resp);
		}else if("details".equals(op)) {
			//调用通过id查询的方法
			details(req,resp);
		}else if("addans".equals(op)) {
			saveInviAns(req,resp);
		}
	}
	

    //回复增加
    private void saveInviAns(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	// 得到系统的默认时间
    	Date date = new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    	String userId = req.getParameter("userId");
    	String invitationId=req.getParameter("invitationId");
    	String ansMessage = req.getParameter("ansMessage");
    	String ansId = userId+format.format(date);
    	// 創建要報錯的回復對象
    	invitation_ans ans = new invitation_ans(ansId, ansMessage, invitationId, userId);
    	boolean isOk = is.saveInviAns(ans);
    	if(isOk) {
    		details(req,resp);
    	}else {
    		resp.sendRedirect("server/single-no-sidebar.jsp");
    	}
		
	}

    //回复页面显示
	private void details(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

    	//获取页面
    	String invitationId=req.getParameter("invitationId");
    	Map<String, Object> ins=is.findDetails(invitationId);
    	req.getSession().setAttribute("ins", ins);
		resp.sendRedirect("server/single-no-sidebar.jsp");
		
	}
    
    

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
    	//获取页面
    	String invitationId=req.getParameter("invitationId");
    	String invitationMessage=req.getParameter("invitationMessage");
    	int plateId =Integer.parseInt(req.getParameter("plateId")) ;
		int categoryId =Integer.parseInt(req.getParameter("categoryId")) ;
    	
		Invitation invi =new Invitation(invitationId,invitationMessage, plateId, categoryId);
		
		//System.out.println(invitationId+","+invitationMessage+","+categoryId);
		
		boolean isOk=is.update(invi);
		PrintWriter out=resp.getWriter();
    	//返回到页面的数据，提示成功或失败
    	if (isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush(); 
    	
    	
		
	}

	//查询id修改
    private void findById(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//获得id值
    	String invitationId=req.getParameter("invitationId");
    	Invitation isOk=is.findById(invitationId);
		if(isOk!=null) {
			req.getSession().setAttribute("find", isOk);
			req.getRequestDispatcher("server/order-edit.jsp").forward(req,resp);
		}
    	
    	
	}
    
    
    

	//增加
    private void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
    	//获取页面数据
    	String invitationMessage=req.getParameter("invitationMessage");
    	int plateId =Integer.parseInt(req.getParameter("plateId")) ;
		int categoryId =Integer.parseInt(req.getParameter("categoryId")) ;
    	String userId=(String)req.getSession().getAttribute("userId");
    	
    	
		/*
		 * System.out.println(invitationMessage); System.out.println(categoryId);
		 */
    	//默认时间
    	Date date=new Date();
    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String invitationId = userId+format.format(date);
    	
		Invitation invi = new Invitation(invitationId, invitationMessage, userId, plateId, categoryId);
		boolean isOk=is.add(invi);
		PrintWriter out=resp.getWriter();
    	//返回到页面的数据，提示成功或失败
    	if (isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush(); 
		
	}
    
    

	//通过id删除
	private void delById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//获得页面帖子id
		String invitationId=req.getParameter("invitationId");
		//System.out.println(invitationId);
		boolean isOk=is.delById(invitationId);
		if(isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush();
		
	}

	
	//显示到页面
	protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		List<Invitation> list=is.findAll();
		req.setAttribute("list", list);
		
		
		List<Plant> plist=is.show();
		req.getSession().setAttribute("plist", plist);
		
		List<category> clist=is.showCate();
		req.getSession().setAttribute("clist",clist);
		
		
		
		//跳转页面
		req.getRequestDispatcher("server/order-list.jsp").forward(req, resp);
		
	}

	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
