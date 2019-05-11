package Demo;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pojo.Logininfo;
import pojo.Userinfo;
import service.ILogininfoService;
import util.SimpleHttpClient;
import dao.AccountMapper;
import dao.IplogMapper;
import dao.LogininfoMapper;
import dao.UserinfoMapper;
import exception.LoginInfoException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountText {
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private IplogMapper iplogMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Test
	public void accountQueryText(){
		assertNotNull(accountMapper.queryById(6));
	}
	@Test
	public void iplogQueryLastTimeById(){
		Date date = iplogMapper.querylastLoginTimeById((long) 6);
		System.out.println(date);
		assertNotNull(date);
	}
	@Test
	public void queryUserInfoByIdText(){
		Userinfo ui = userinfoMapper.queryUserInfoById((long) 6);
		assertNotNull(ui);
	}
	@Test
	public void SimpleHttpClientText() throws Exception{
		String acc = SimpleHttpClient.sendPhoneMessage("18470401930", "123456");
		System.out.println(acc);
		assertNotNull(acc);
	}
}
