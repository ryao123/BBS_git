package com.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.entity.user;
import com.service.user.UserService;
import com.service.user.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	UserService us = new UserServiceImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ���ñ���
		req.setCharacterEncoding("UTF-8");
		// ��� op����ֵ
		String op = req.getParameter("op");
		

		if ("upload".equals(op)) {
			// ִ�����Ӳ���
			upload(req, resp);
		} else if ("Add".equals(op)) {
			//�����ύ
			AddUser(req, resp);
		}else if ("findAll".equals(op)) {
			//ҳ����ʾ
			findAll(req, resp);
		} else if ("UserDelete".equals(op)) {
			//�û�ɾ��
			UserDelete(req, resp);
		}else if ("UserfindId".equals(op)) {
			//�޸���ʾ
			UserfindId(req, resp);
		} else if ("update".equals(op)) {
			//�޸���Ϣ
			update(req, resp);
		}else if("QueryUser".equals(op)) {
			//��ѯ
			QueryUser(req,resp);
		}else if("delAll".equals(op)) {
			//ͨ��id����ɾ��
			delAll(req,resp);
		}
	}

	private void upload(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		
		String userEmail = null;
		String userId = null;
		String userPsw = null;
		String userSex = null;
		String userPhoto = null;
		// ����ļ��ϴ���·��getServletContext().getRealPath("/file");
		String filePath = this.getServletContext().getRealPath("/static/file");
		// �鿴�Ƿ���ServletFileUpload
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		if (isMultipart) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory); // ��ñ��е��������� ����10M
			upload.setFileSizeMax(10 * 1024 * 1024);
			try {
				List<FileItem> items = upload.parseRequest(req); // �������е�����
				Iterator<FileItem> it = items.iterator();
				while (it.hasNext()) { // ȡ��Ԫ�ض���
					FileItem item = it.next();
					// �ж��Ƿ�����ͨ�ı�Ԫ��
					if (item.isFormField()) {
						String name = item.getFieldName();// �õ����е�ֵ
						switch (name) {
						case "userEmail":
							userEmail = item.getString("UTF-8");
							break;
						case "userId":
							userId = item.getString("UTF-8");
							break;
						case "userPsw":
							userPsw = item.getString("UTF-8");
							break;
						case "userSex":
							userSex = item.getString("UTF-8");
							break;
						}
					} else {
						userPhoto = item.getName();
						// ����һ���ϴ��ļ��Ķ���
						File saveFile = new File(filePath, userPhoto);
						item.write(saveFile);
						req.getServletContext().setAttribute("userPhoto",userPhoto);
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		

	}
	
	private void AddUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		//��ȡaddҳ������� 
		String userId=req.getParameter("userId"); 
		String  userPsw=req.getParameter("userPsw"); 
		String  userEmail=req.getParameter("userEmail");
		String  userSex=req.getParameter("userSex"); //���÷���
		String userPhoto=(String) req.getServletContext().getAttribute("userPhoto");
		//��������
		userPsw = DigestUtils.md5Hex(userPsw);
		
		user user=new user(userId, userPsw, userEmail, userSex, userPhoto);
		
		PrintWriter out = resp.getWriter();
		boolean isOk=us.memberAdd(user);
		if(isOk) {
			out.write("true");
			//resp.sendRedirect("UserServlet?op=findAll");
		}else {
			out.write("false");
		}
		out.flush();
		
	}
	
	  
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// ��ʾ��������
		List<user> list = us.getAll();
				
		req.setAttribute("list",list);
				
		req.getRequestDispatcher("server/member-list.jsp").forward(req,resp);

	
	}
	
	
	
	private void UserDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// ɾ���˺�
		// ���id
		String userId = req.getParameter("userId");
		boolean isOk = us.userDelete(userId);

		if(isOk){
			resp.sendRedirect("UserServlet?op=findAll");
			}else{
				resp.sendRedirect("UserServlet?op=findAll");
			}
		
		
	}
	
	private void UserfindId(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// �޸Ĳ�ѯ

		// �����ַ�����
		req.setCharacterEncoding("UTF-8");
		// ��ȡid
		String userId=req.getParameter("userId");
		user find=us.finduserId(userId);
		req.setAttribute("find",find);
		req.getRequestDispatcher("server/member-edit.jsp").forward(req,resp);

	}
	
	
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		// ��ȡҳ�������
		String userId = req.getParameter("userId");
		String userPsw = req.getParameter("userPsw");
		String userEmail = req.getParameter("userEmail");
		String userSex = req.getParameter("userSex");
		
		//System.out.println(userId);
		//��������
		userPsw = DigestUtils.md5Hex(userPsw);
		// ���÷���
		user user = new user(userId, userPsw, userEmail, userSex);
		PrintWriter out = resp.getWriter();
		boolean isOk = us.update(user);
		if(isOk){
			out.write("true");
		}else{
			out.write("false");
			}
		out.flush();

		}
		
	
	private void QueryUser(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		List<user> lists = new ArrayList<user>();
		//��ȡҳ���ѯ����;
		
				String userId = req.getParameter("userId");
				if (userId != null) {
					lists = us.QueryUser(userId);
				}else {
					lists = us.getAll();
				}
			
		 req.setAttribute("list",lists);
		 req.getRequestDispatcher("server/member-list.jsp").forward(req,resp);
		 
		
	}
	
	
	private void delAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String userIds = req.getParameter("userIds");
		//["test001","test002"]
		PrintWriter out = resp.getWriter();
		boolean isOk = us.delAll(userIds);
		if(isOk) {
			out.write("true");
		}else {
			out.write("false");
		}
		out.flush();
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
