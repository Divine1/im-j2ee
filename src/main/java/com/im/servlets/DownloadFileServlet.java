package com.im.servlets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadFileServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String filepath = null;
		//filepath = "/Users/dev/Applications/codes/java/eclipse_ws/ws1/im-j2ee/Appointment Instructions-POINTS.pdf";
		filepath="/Users/dev/Applications/codes/java/eclipse_ws/ws1/im-j2ee/pic4.jpg";
		String realfilepath = req.getServletContext().getRealPath(filepath);
		System.out.println("filepath " + filepath);
		//filepath=realfilepath;
		System.out.println("realfilepath " + realfilepath);

		File downloadFile = new File(filepath);
		FileInputStream inStream = new FileInputStream(downloadFile);


		ServletContext context = getServletContext();
		String mimeType = context.getMimeType(filepath);
		System.out.println("mimeType " + mimeType);
		if (mimeType == null) {
			mimeType = "application/octet-stream";
		}

		resp.setContentType(mimeType);
		resp.setContentLength((int) downloadFile.length());

		// forces download
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
		resp.setHeader(headerKey, headerValue);

		// obtains response's output stream
		OutputStream outStream = resp.getOutputStream();

		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		while ((bytesRead = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, bytesRead);
		}

		inStream.close();
		outStream.close();

	}

}
