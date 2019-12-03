package com.im.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AgentServlet2 extends HttpServlet {

	public AgentServlet2() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doget");
		req.getRequestDispatcher("/agentform.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in doPost");

		String agentname=req.getParameter("agentname");
		String agentid=req.getParameter("agentid");
		req.getSession().setAttribute("agentname", agentname);
		req.getSession().setAttribute("agentid", agentid);
		req.getRequestDispatcher("/agentdetails.jsp").forward(req, resp);
	}

}
