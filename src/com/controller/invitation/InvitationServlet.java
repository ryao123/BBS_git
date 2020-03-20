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
		
		//��ÿͻ��˴��ݵĲ���ֵ
		req.setCharacterEncoding("UTF-8");
		String op=req.getParameter("op");
		if("findAll".equals(op)) {
			//������ʾ�������ݵķ���
			findAll(req,resp);
		}else if("add".equals(op)) {
			//�������ӵķ���
			add(req,resp);
		}else if("delById".equals(op)) {
			//����ͨ��ɾ��id��ѯ�ķ���
			delById(req,resp);
		}else if("findById".equals(op)) {
			//����ͨ��id��ѯ�ķ���
			findById(req,resp);
		}else if("update".equals(op)) {
			//����ͨ��id��ѯ�ķ���
			update(req,resp);
		}else if("details".equals(op)) {
			//����ͨ��id��ѯ�ķ���
			details(req,resp);
		}else if("addans".equals(op)) {
			saveInviAns(req,resp);
		}
	}
	

    //�ظ�����
    private void saveInviAns(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    	// �õ�ϵͳ��Ĭ��ʱ��
    	Date date = new Date();
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
    	String userId = req.getParameter("userId");
    	String invitationId=req.getParameter("invitationId");
    	String ansMessage = req.getParameter("ansMessage");
    	String ansId = userId+format.format(date);
    	// ����Ҫ���e�Ļ؏͌���
    	invitation_ans ans = new invitation_ans(ansId, ansMessage, invitationId, userId);
    	boolean isOk = is.saveInviAns(ans);
    	if(isOk) {
    		details(req,resp);
    	}else {
    		resp.sendRedirect("server/single-no-sidebar.jsp");
    	}
		
	}

    //�ظ�ҳ����ʾ
	private void details(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

    	//��ȡҳ��
    	String invitationId=req.getParameter("invitationId");
    	Map<String, Object> ins=is.findDetails(invitationId);
    	req.getSession().setAttribute("ins", ins);
		resp.sendRedirect("server/single-no-sidebar.jsp");
		
	}
    
    

	private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
    	//��ȡҳ��
    	String invitationId=req.getParameter("invitationId");
    	String invitationMessage=req.getParameter("invitationMessage");
    	int plateId =Integer.parseInt(req.getParameter("plateId")) ;
		int categoryId =Integer.parseInt(req.getParameter("categoryId")) ;
    	
		Invitation invi =new Invitation(invitationId,invitationMessage, plateId, categoryId);
		
		//System.out.println(invitationId+","+invitationMessage+","+categoryId);
		
		boolean isOk=is.update(invi);
		PrintWriter out=resp.getWriter();
    	//���ص�ҳ������ݣ���ʾ�ɹ���ʧ��
    	if (isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush(); 
    	
    	
		
	}

	//��ѯid�޸�
    private void findById(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		//���idֵ
    	String invitationId=req.getParameter("invitationId");
    	Invitation isOk=is.findById(invitationId);
		if(isOk!=null) {
			req.getSession().setAttribute("find", isOk);
			req.getRequestDispatcher("server/order-edit.jsp").forward(req,resp);
		}
    	
    	
	}
    
    
    

	//����
    private void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
    	//��ȡҳ������
    	String invitationMessage=req.getParameter("invitationMessage");
    	int plateId =Integer.parseInt(req.getParameter("plateId")) ;
		int categoryId =Integer.parseInt(req.getParameter("categoryId")) ;
    	String userId=(String)req.getSession().getAttribute("userId");
    	
    	
		/*
		 * System.out.println(invitationMessage); System.out.println(categoryId);
		 */
    	//Ĭ��ʱ��
    	Date date=new Date();
    	SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String invitationId = userId+format.format(date);
    	
		Invitation invi = new Invitation(invitationId, invitationMessage, userId, plateId, categoryId);
		boolean isOk=is.add(invi);
		PrintWriter out=resp.getWriter();
    	//���ص�ҳ������ݣ���ʾ�ɹ���ʧ��
    	if (isOk) {
			out.write("{\"result\":\"true\"}");
		}else {
			out.write("{\"result\":\"false\"}");
		}
		out.flush(); 
		
	}
    
    

	//ͨ��idɾ��
	private void delById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//���ҳ������id
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

	
	//��ʾ��ҳ��
	protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		List<Invitation> list=is.findAll();
		req.setAttribute("list", list);
		
		
		List<Plant> plist=is.show();
		req.getSession().setAttribute("plist", plist);
		
		List<category> clist=is.showCate();
		req.getSession().setAttribute("clist",clist);
		
		
		
		//��תҳ��
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
