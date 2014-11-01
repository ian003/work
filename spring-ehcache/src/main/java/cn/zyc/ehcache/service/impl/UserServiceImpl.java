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

	public User load(User bean) {
		return userDAO.load(bean);
	}

	public List<User> list() {
		return userDAO.list();
	}
}
