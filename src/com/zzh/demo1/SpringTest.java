package com.zzh.demo1;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class SpringTest {
	@Resource(name="accountService")
	private AccountService accountService;

	@Test
	public void demo1(){
		accountService.transfer("aaa", "bbb", 200d);
	}
}
