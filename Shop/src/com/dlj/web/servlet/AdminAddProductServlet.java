package com.dlj.web.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import com.dlj.domain.Category;
import com.dlj.domain.Product;
import com.dlj.service.AdminService;
import com.dlj.utils.BeanFactory;
import com.dlj.utils.CommonUtils;

public class AdminAddProductServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 收集表单的数据，封装一个Product实体
		// 创建磁盘文件项工厂
		Product pro = new Product();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 创建文件上传核心对象
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解析request获得的文件项对象集合

			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				// 判断是否是普通表单项
				boolean formField = item.isFormField();
				if (formField) {
					// 普通表单项里的数据封装到Product 对象中
					String fieldName = item.getFieldName();
					String fieldValue = item.getString("UTF-8");
					map.put(fieldName, fieldValue);
				} else {
					// 文件上传项
					// 获得问今名称和文件内容
					String fileName = item.getFieldName();
					String path = this.getServletContext().getRealPath("upload");
					InputStream in = item.getInputStream();
					OutputStream out = new FileOutputStream(path + "/" + fileName);
					// 文件拷贝
					IOUtils.copy(in, out);
					// 封装图片的相对路径
					map.put("pimage", "upload/" + fileName);
					in.close();
					out.close();
					item.delete();
				}
			}
			BeanUtils.populate(pro, map);
			pro.setPid(CommonUtils.getUUID().toString());
			pro.setPdate(new Date());
			pro.setPflag(0);
			Category category = new Category();
			category.setCid(map.get("cid").toString());
			pro.setCategory(category);
			AdminService service = (AdminService) BeanFactory.getBean("adminService");
			service.addProduct(pro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().write("hello dlj");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}