package com.lg.gz.spring;

import com.lg.gz.spring.domain.*;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zzq_eason on 2016/6/17.
 */

@Controller
public class TestController {

	/**
	 * http://localhost:8080/SpringMVC/baseType.do?age=1
	 */
	@RequestMapping(value = "baseType.do")
	@ResponseBody
	// @RequestParam("xage")表示这个参数（xage）是必须的
	public String baseType(@RequestParam("xage") int age) {
		System.out.println(age);
		return "age = " + age;
	}

	/**
	 * http://localhost:8080/SpringMVC/baseType1.do?age=1，参数可以为空，包装类型
	 */
	@RequestMapping(value = "baseType1.do")
	@ResponseBody
	public String baseType1(Integer age) {
		System.out.println(age);
		return "age = " + age;
	}

	/**
	 * http://localhost:8080/SpringMVC/array.do?strs=10&strs=1231&strs=salfjlas 数组传递的方式
	 */
	@RequestMapping(value = "array.do")
	@ResponseBody
	public String array(String[] strs) {
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			strBuffer.append(strs[i] + "	");
		}
		System.out.println(strBuffer.toString());
		return "strs = " + strBuffer.toString();
	}

	/**
	 * 参数的传递：直接传递User类中的属性名即可，这是没有包含其他类
	 * http://localhost:8080/SpringMVC/user.do?name=stses&age=20
	 * 包含其他的类时参数的传递为：
	 * http://localhost:8080/SpringMVC/user.do?name=asfdjalsf&age=50&contactInfo.phone=20015255&contactInfo.address=safsagadsfg
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "user.do")
	@ResponseBody
	public String user(User user) {
		System.out.println(user);
		return "user = " + user;
	}

	/**
	 * http://localhost:8080/SpringMVC/userAdmin.do?user.name=12123&admin.name=2334r3124&age=90
	 * 访问此URL时会先去执行initUser和initAdmin方法，这就使得属性不同赋值生效
	 *
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "userAdmin.do")
	@ResponseBody
	public String user(User user, Admin admin) {
		System.out.println("user = " + user + ", admin = " + admin);
		return "user = " + user + " admin = " + admin;
	}

	/**
	 * 此方法会在访问URL之前被执行，这样就可以断数据绑定到那个封装对象中
	 *
	 * @param binder
	 */
	@InitBinder("user")
	public void initUser(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("user.");
	}

	@InitBinder("admin")
	public void initAdmin(WebDataBinder binder) {
		binder.setFieldDefaultPrefix("admin.");
	}

	/**
	 * http://localhost:8080/SpringMVC/list.do?users[0].name=afdsa&users[1].name=fsdafdsa
	 * 参数的设置直接使用UserListForm类中的属性，如上URL，需要添加索引
	 * 注意：请求索引要是连续，不然会有空值出现
	 *
	 * @param userListForm
	 * @return
	 */
	@RequestMapping(value = "list.do")
	@ResponseBody
	public String list(UserListForm userListForm) {
		System.out.println("userList = " + userListForm);
		return userListForm.toString();
	}

	/**
	 * http://localhost:8080/SpringMVC/set.do?users[0].name=wuxiao&users[1].name=zzqeason
	 * 首先得现在实体类中初始化绑定数据，之后才使用参数的传递
	 *
	 * @param userSetForm
	 * @return
	 */
	// todo 问题是hashcode的问题存在
	@RequestMapping(value = "set.do")
	@ResponseBody
	public String set(UserSetForm userSetForm) {
		System.out.println("userSet = " + userSetForm);
		return userSetForm.toString();
	}

	/**
	 * localhost:8080/SpringMVC/map.do?users['x'].name=wuxiao&users['x'].age=15&users['y'].name=xioaxioa&users['y'].age=20
	 * 参数的设定如上URL中显示
	 *
	 * @param userMapForm
	 * @return
	 */
	@RequestMapping(value = "map.do")
	@ResponseBody
	public String map(UserMapForm userMapForm) {
		System.out.println("userMap = " + userMapForm);
		return userMapForm.toString();
	}

	/**
	 * 请求的参数写在request的body中，可以写表单提交
	 *
	 * @param user
	 * @return
	 */
	// todo 编写表单验证
	@RequestMapping(value = "json.do")
	@ResponseBody
	public String json(@RequestBody User user) {
		System.out.println("user = " + user);
		return user.toString();
	}

	@RequestMapping(value = "xml.do")
	@ResponseBody
	public String xml(@RequestBody Admin admin) {
		System.out.println("admin = " + admin);
		return admin.toString();
	}

	/**
	 * http://localhost:8080/SpringMVC/converter.do?bool=no
	 * 参数的设定是依据：StringToBooleanConverter中的trueValues和falseValues值来判断是true or false
	 *
	 * @param bool
	 * @return
	 */
	@RequestMapping(value = "converter.do")
	@ResponseBody
	public String converter(Boolean bool) {
		return bool.toString();
	}

	/**
	 * http://localhost:8080/SpringMVC/date1.do?date=2012-02-05
	 * 参数的绑定通过下面的initDate1进行初始化参数绑定
	 *
	 * @param date
	 * @return
	 */
	@RequestMapping(value = "date1.do")
	@ResponseBody
	public String date1(Date date) {
		return date.toString();
	}

	/**
	 * 这种初始化方式只能解决一个某个特定的变量类型，如果变量多则不可采取此种方式
	 * 需要使用全局的配置来进行数据绑定配置
	 *
	 * @param binder
	 */
//	@InitBinder("date")
//	public void initDate1(WebDataBinder binder) {
//		// 此处是通过数据绑定注册，将Date类型的数据转换成CustomDateEditor类型，其中的“true”：表示可以为空
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
//	}

	/**
	 * localhost:8080/SpingMVC/book
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	@ResponseBody
	public String book(HttpServletRequest request) {
		String contentType = request.getContentType();
		if (contentType == null) {
			return "book.default";
		} else if (contentType.equals("txt")) {
			return "book.txt";
		} else if (contentType.equals("html")) {
			return "book.html";
		}

		return "book.default";
	}

	/**
	 * localhost:8080/SpringMVC/subject/0001
	 * @param subjectId
	 * @return
	 */
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.GET)
	@ResponseBody
	public String subjectGet(@PathVariable("subjectId") String subjectId) {
		return "this is get method, subjectId = " + subjectId;
	}
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.POST)
	@ResponseBody
	public String subjectPost(@PathVariable("subjectId") String subjectId) {
		return "this is post method, subjectId = " + subjectId;
	}

	/**
	 * 这是删除
	 * @param subjectId
	 * @return
	 */
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.DELETE)
	@ResponseBody
	public String subjectDelete(@PathVariable("subjectId") String subjectId) {
		return "this is delete method, subjectId = " + subjectId;
	}

	/**
	 * put不只限于更新
	 * @param subjectId
	 * @return
	 */
	@RequestMapping(value = "/subject/{subjectId}", method = RequestMethod.PUT)
	@ResponseBody
	public String subjectPut(@PathVariable("subjectId") String subjectId) {
		return "this is put method, subjectId = " + subjectId;
	}



}
