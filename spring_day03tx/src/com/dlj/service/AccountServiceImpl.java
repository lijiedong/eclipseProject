package com.dlj.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dlj.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
	private AccountDao ad;
	// private TransactionTemplate tt;

	/*
	 * public void setTt(TransactionTemplate tt) { this.tt = tt; }
	 */

	@Override
	@Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = false)
	public void transfer(Integer from, Integer to, Double money) {
		ad.decreaseMoney(from, money);
		// int i = 1 / 0;
		// 加钱
		ad.increaseMoney(to, money);
	}

	public void setAd(AccountDao ad) {
		this.ad = ad;
	}

}
