package com.dlj.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	private String oid;// 订单号
	private Date ordertime;// 下单时间
	private double total;// 订单总金额
	private int state;// 订单支付状态，1代表已支付，0代表未支付
	private String address;// 收货地址
	private String name;// 收货人
	private String telephone;// 收货人电话
	private User user;// 订单所属用户
	List<OrderItem> orderItems = new ArrayList<OrderItem>();

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public int getState() {
		return state;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", ordertime=" + ordertime + ", total=" + total + ", state=" + state + ", address="
				+ address + ", name=" + name + ", telephone=" + telephone + ", user=" + user + ", orderItems="
				+ orderItems + "]";
	}

}
