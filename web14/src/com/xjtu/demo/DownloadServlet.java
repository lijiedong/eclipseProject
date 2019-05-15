package com.xjtu.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

public class DownloadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().write("hello dlj");
		//1.1获得要下载的文件的名称
		String filename=request.getParameter("filename");
		//解决文件的中文乱码
		filename=new String(filename.getBytes("ISO8859-1"),"utf-8");
		//获得请求头中的user-agent
		String agent=request.getHeader("User-Agent");
		String filenameEncoder="";
		if (agent.contains("MSIE")) {
			// IE浏览器
			filenameEncoder = URLEncoder.encode(filename, "utf-8");
			filenameEncoder = filenameEncoder.replace("+", " ");
	} else if (agent.contains("Firefox")) {
			// 火狐浏览器
	BASE64Encoder base64Encoder = new BASE64Encoder();
	filenameEncoder = "=?utf-8?B?"
					+ base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
	} else {
			// 其它浏览器
		filenameEncoder = URLEncoder.encode(filename, "utf-8");				
	}

		//要下载文件的文件类型
		
		response.setContentType(this.getServletContext().getMimeType(filename));
		//告诉客户端文件不是直接解析而是下载
		response.setHeader("Content-Disposition", "attachment;filename="+filenameEncoder);
		//获得该文件的绝对路径
		String path=this.getServletContext().getRealPath("download/"+filename);
		//获得该文件的输入流
		System.out.println(path);
		InputStream in=new FileInputStream(path);
		//获得输出流
		ServletOutputStream out=response.getOutputStream();
		//文件拷贝
		int len=0;
		byte[] buffer=new byte[1024];
		while((len=in.read(buffer))>0){
			out.write(buffer,0,len);
		}
		
		in.close();
		out.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}