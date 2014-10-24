package cn.zyc.ehcache.service.impl;

import java.util.List;

import cn.zyc.ehcache.dao.UserDAO;
import cn.zyc.ehcache.pojo.User;
import cn.zyc.ehcache.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User loadById(int id) {
		return userDAO.loadById(id);
	}

	public List<User> list() {
		System.out.println("list ...");
		return userDAO.list();
	}
}
