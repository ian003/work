package cn.zyc.ehcache.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zyc.ehcache.pojo.User;
import cn.zyc.ehcache.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/list.do", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap list(HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		List<User> list = userService.list();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/load.do", method = RequestMethod.POST)
	public @ResponseBody
	User load(HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		String id = request.getParameter("id");
		User user = new User();
		user.setId(Integer.valueOf(id));
		user = userService.load(user);
		return user;
	}

}
