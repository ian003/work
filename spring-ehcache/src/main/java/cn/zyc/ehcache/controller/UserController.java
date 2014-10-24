package cn.zyc.ehcache.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/list.do")
	public @ResponseBody
	ModelMap list(HttpServletRequest request, HttpServletResponse response,
			ModelMap map) {
		List<User> list = userService.list();
		map.put("list", list);
		return map;
	}

}
