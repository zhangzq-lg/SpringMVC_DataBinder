package com.lg.gz.spring.domain;

import java.util.List;

/**
 * 用户绑定list集合的数据
 * Created by zzq_eason on 2016/6/17.
 */
public class UserListForm {

	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserListForm{" +
				"users=" + users +
				'}';
	}
}
