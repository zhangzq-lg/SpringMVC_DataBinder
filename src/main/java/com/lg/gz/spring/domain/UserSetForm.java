package com.lg.gz.spring.domain;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 用于绑定set集合的数据
 * 通过User实体类中复写的方法来判断是否是同一个对象
 * 这样就可以满足set集合的特性，元素不能重复
 *
 * Created by zzq_eason on 2016/6/17.
 */
public class UserSetForm {

	private Set<User> users;

	/**
	 * 在使用此数据绑定时，必须先初始化，赋初值
	 */
	private UserSetForm() {
		users = new LinkedHashSet<User>();
		users.add(new User());
		users.add(new User());
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserSetForm{" +
				"users=" + users +
				'}';
	}

}
