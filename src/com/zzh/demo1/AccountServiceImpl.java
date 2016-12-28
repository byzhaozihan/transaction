package com.zzh.demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class AccountServiceImpl implements AccountService {
	//注入DAO类
	private AccountDao accountDao;
	

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	
	//注入事务管理模板
	private TransactionTemplate transactionTemplate;
	
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	/**
	 *  注意java8中已经没有匿名内部类和局部内部类只能访问final变量的限制了！ 
	 *  匿名内部类访问外部的局部变量时该变量为什么必须是final的？
	 *  总结一下，就是会导致局部变量提升为一种隐式的成员变量。
	 *  在匿名类中需要传递进来final关键字，java希望的是保证内部实现和外在表现的一致性
	 *  
	 */
	@Override
	public void transfer( String out,  String in,  Double money) {
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
				accountDao.outMoney(out, money);
				int i = 1 / 0;
				accountDao.inMoney(in, money);
			}
		});
	}

}
