package com.lg.gz.spring.domain;

import java.util.Map;

/**
 * map数据绑定实体类
 * Created by zzq_eason on 2016/6/18.
 */
public class UserMapForm {

	private Map<String, User> users;

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserMapForm{" +
				"users=" + users +
				'}';
	}

}
