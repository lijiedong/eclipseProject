package com.dlj.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class FileuploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// 1. 创建磁盘文件项工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2.创建文件上传的核心类

			ServletFileUpload upload = new ServletFileUpload(factory);
			// 3.解析request，获得文件项集合
			List<FileItem> parseRequest = upload.parseRequest(request);
			// 4.遍历文件项集合
			for (FileItem item : parseRequest) {
				// 5.判断是普通表单项还是文件上传项
				boolean formField = item.isFormField();// 判断是否是一个普通表单项
				if (formField) {
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					System.out.println(fieldName + ":" + fieldValue);
				} else {
					// 获得文件项
					// 获得上传文件的名称
					String fileName = item.getName();
					// 获得上传文件的内容
					InputStream in = item.getInputStream();
					// 将in中的数据拷贝到服务器上
					String path = this.getServletContext().getRealPath("upload");
					OutputStream out = new FileOutputStream(path + "/" + fileName);
					int len = 0;
					byte[] buffer = new byte[1024];
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
				}

			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}