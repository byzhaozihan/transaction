package com.zzh.demo4;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * DAO层接口实现类
 * 这里使用的是JdbcDaoSupport模板
 *
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

	@Override
	public void outMoney(String out, Double money) {
		String sql = "update account set money = money - ? where name = ?";
		this.getJdbcTemplate().update(sql,money,out);
	}

	@Override
	public void inMoney(String in, Double money) {
		String sql = "update account set money = money + ? where name = ?";
		this.getJdbcTemplate().update(sql,money,in);
	}

}
