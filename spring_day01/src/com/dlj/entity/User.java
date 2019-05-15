package com.dlj.entity;

public class User {
	private String name;
	private Integer age;
	private Car car;

	public User(String name, Car car) {
		System.out.println("构造函数注入！");
		this.name = name;
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public User() {
		System.out.println("User对象空参构造方法！");
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

	public String toString() {
		return "User [name=" + name + ", age=" + age + ", car=" + car + "]";
	}

}
