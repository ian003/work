package cn.zyc.ehcache.service;

import java.util.List;

import cn.zyc.ehcache.pojo.User;

public interface UserService {

	User loadById(int id);

	List<User> list();
}
