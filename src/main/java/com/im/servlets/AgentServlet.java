package com.im.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class AgentServlet extends HttpServlet {

	public AgentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doget");
		req.getRequestDispatcher("/agentform.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doPost");

		Map<String, String> map = new HashMap<>();

		String filepath = "/Users/dev/Applications/codes/java/eclipse_ws/ws1/im-j2ee";
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> listFileItem = servletFileUpload.parseRequest(req);
			System.out.println("listFileItem size " + listFileItem.size());
			listFileItem.forEach(item -> {
				try {
					String itemName = item.getName();
					System.out.println("itemName " + itemName);
					
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = item.getString();
						System.out.println("name " + name + " -value- " + value);
						map.put(name, value);
					} else {
						System.out.println("writing file");
						File file = new File(filepath + "/" + itemName);
						ifFileExistsThenDelete(file);
						item.write(file);
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("map " + map);
		
		resp.setStatus(resp.SC_OK);
		PrintWriter out = resp.getWriter();
		//resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");
		out.print("hello");
		out.flush();
	}

	void first(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doPost");
		String agency_id = req.getParameter("agency_id");
		String refreshsession = req.getParameter("refreshsession");
		String delta = req.getParameter("delta");
		Map<String, String> map = new HashMap<>();

		// String ufile=req.getParameter("ufile");
		String filepath = "/Users/dev/Applications/codes/java/eclipse_ws/ws1/im-j2ee";
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		try {
			List<FileItem> listFileItem = servletFileUpload.parseRequest(req);
			System.out.println("listFileItem size " + listFileItem.size());
			listFileItem.forEach(item -> {
				try {
					String itemName = item.getName();
					System.out.println("itemName " + itemName);
					if (item.isFormField()) {
						String name = item.getFieldName();
						String value = item.getString();
						System.out.println("name " + name + " -value- " + value);
						map.put(name, value);
					} else {
						System.out.println("writing file");
						File file = new File(filepath + "/" + itemName);
						ifFileExistsThenDelete(file);
						item.write(file);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("map " + map);
		req.getSession().setAttribute("agency_id", map.get("agency_id"));
		req.getSession().setAttribute("refreshsession", map.get("refreshsession"));
		req.getSession().setAttribute("delta", map.get("delta"));

		req.getRequestDispatcher("/agentdetails.jsp").forward(req, resp);
	}

	public void ifFileExistsThenDelete(File file) {
		if (file.exists()) {
			System.out.println("file exists");
			boolean deleteflag = file.delete();
			System.out.println("deleteflag " + deleteflag);
		} else {
			System.out.println("file not exists");

		}
	}
}
