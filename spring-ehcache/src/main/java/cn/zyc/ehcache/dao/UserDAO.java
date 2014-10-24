package cn.zyc.ehcache.dao;

import java.util.List;

import cn.zyc.ehcache.pojo.User;

public interface UserDAO {

	User loadById(int id);

	List<User> list();
}
