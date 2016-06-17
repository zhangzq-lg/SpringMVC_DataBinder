package com.lg.gz.spring.domain;

import java.util.Objects;

/**
 * 重新定义判定是否是同一个对象的规则
 * Created by zzq_eason on 2016/6/17.
 */
public class User {

	private String name;
	private Integer age;
	private ContactInfo contactInfo;

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * 复写父类中的方法，为了进行自身比较
	 *
	 * @param obj
	 * @return
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || this.getClass() != obj.getClass()) return false;
		User u = (User) obj;
		return Objects.equals(this.name, u.getName()) && Objects.equals(this.age, u.getAge());
	}

	/**
	 * 复写父类中的hashCode方法，重新定义判断规则（是否是同一个对象）
	 *
	 * @return
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name, age);
	}

	@Override
	public String toString() {
		return "User{" +
				"name='" + name + '\'' +
				", age=" + age +
				", contactInfo=" + contactInfo +
				'}';
	}
}
