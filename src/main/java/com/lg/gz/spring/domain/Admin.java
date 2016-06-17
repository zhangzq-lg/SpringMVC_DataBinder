package com.lg.gz.spring.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 使用此类作为xml数据传输格式，使用注解配置
 * 使得此类编程xml文档
 * Created by zzq_eason on 2016/6/17.
 */
@XmlRootElement(name = "admin")
public class Admin {

	private String name;
	private Integer age;

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "age")
	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Admin{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}

}
