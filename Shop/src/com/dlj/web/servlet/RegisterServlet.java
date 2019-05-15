package com.dlj.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import com.dlj.domain.User;
import com.dlj.service.UserService;
import com.dlj.utils.CommonUtils;
import com.dlj.utils.MailUtils;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 解决中文乱码
		request.setCharacterEncoding("UTF-8");
		// 获得表单的数据
		Map<String, String[]> parameterMap = request.getParameterMap();
		User user = new User();
		try {
			// 自己指定一个日期转换器，将String转成Date
			ConvertUtils.register(new Converter() {

				@Override
				public Object convert(Class arg0, Object value) {
					// TODO Auto-generated method stub
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					Date parse = null;
					try {
						parse = format.parse(value.toString());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return parse;
				}

			}, Date.class);
			BeanUtils.populate(user, parameterMap);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// uid,telephone,state,code,uuid
		String uuid = CommonUtils.getUUID();
		user.setUid(uuid);
		user.setTelephone("15932179035");
		user.setState(0);
		user.setCode(uuid);
		// 将user传递给service层
		UserService service = new UserService();
		Boolean flag = service.register(user);
		// 是否注册成功
		if (flag) {
			// 发送激活工具
			try {
				String activeCode = uuid;
				String emailMsg = "恭喜您注册成功，请点击下面的连接进行激活账户" + "<a href='http://localhost:8080/Shop/active?activeCode="
						+ activeCode + "'>" + "http://localhost:8080/Shop/active?activeCode=" + activeCode + "</a>";
				MailUtils.sendMail(user.getEmail(), emailMsg);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 跳转到注册成功页面
			response.sendRedirect(request.getContextPath() + "/registerSuccess.jsp");
		} else {
			// 跳转到注册失败页面
			response.sendRedirect(request.getContextPath() + "/registerFail.jsp");

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}