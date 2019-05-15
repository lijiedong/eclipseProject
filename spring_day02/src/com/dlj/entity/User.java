package com.dlj.entity;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "user")
// <bean name="user" class="...">
public class User {

	private String name;
	private Integer age;
	/*
	 * @Autowired
	 * 
	 * @Qualifier(value="car")
	 */
	@Resource(name = "car")
	private Car car;

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	@Value(value = "tr")
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
