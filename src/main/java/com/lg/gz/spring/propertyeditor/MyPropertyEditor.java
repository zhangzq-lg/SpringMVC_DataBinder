package com.lg.gz.spring.propertyeditor;

import com.lg.gz.spring.domain.User;
import org.springframework.format.Formatter;

import java.beans.PropertyEditorSupport;

/**
 * Created by zzq_eason on 2016/6/18.
 */
public class MyPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = new User();
		String str[] = text.split(",");
		user.setName(str[0]);;
		user.setAge(Integer.parseInt(str[1]));
		this.setValue(user);
	}

	public static void main(String[] args) {
		String text = "stext,12";
		MyPropertyEditor my = new MyPropertyEditor();
		my.setAsText(text);
		System.out.println(my.getValue());
	}
}
