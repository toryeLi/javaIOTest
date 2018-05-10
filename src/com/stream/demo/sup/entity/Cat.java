package com.stream.demo.sup.entity;

import java.io.Serializable;

/**
 * Cat类实现Serializable接口后就能够被对象输出流序列化
 * @author Administrator
 *
 */
public class Cat implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name; // 名称
	private String sex; // 性别
	private int age; // 年龄
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
