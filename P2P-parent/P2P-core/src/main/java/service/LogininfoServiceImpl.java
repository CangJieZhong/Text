package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.LoginInfoException;
import dao.AccountMapper;
import dao.IplogMapper;
import dao.LogininfoMapper;
import dao.UserinfoMapper;
import pojo.Account;
import pojo.Iplog;
import pojo.Logininfo;
import pojo.Userinfo;
import service.ILogininfoService;
import util.MD5;
import util.UserContext;

@Service
public class LogininfoServiceImpl implements ILogininfoService {

	@Autowired
	private LogininfoMapper logininfoMapper;
	@Autowired
	private IplogMapper iplogMapper;
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	
	
	
	@Override
	public boolean login(String username, String password, int  usertype, String ip)  throws  LoginInfoException {
		Iplog iplog = new Iplog();
		iplog.setIp(ip);
		iplog.setLogintime(new Date());
		iplog.setUsername(username);
		iplog.setLoginstate(Iplog.LOGINSTATE_FAILED);
		iplog.setLogintype(usertype);
		Logininfo  current = logininfoMapper.queryByUsernameAndPassword(username, MD5.encode(password), usertype);
		if(current != null){
			iplog.setLogininfoid(current.getId());
			
			if(current.getState() == Logininfo.STATE_LOCK){
				iplogMapper.insert(iplog);
				throw  new LoginInfoException("账户被锁定,请联系管理员");
			}
			if(current.getState() == Logininfo.STATE_DELETE){
				iplogMapper.insert(iplog);
				throw  new LoginInfoException("账户已注销,请联系管理员");
			}
			UserContext.setCurrent(current);
			iplog.setLoginstate(Iplog.LOGINSTATE_SUCCESS);
		}
		iplogMapper.insert(iplog);
		return current != null;
	}


	@Override
	public boolean checkUsername(String username, int usertype) {
		return logininfoMapper.getCountByUsername(username,usertype) <=  0;
	}


	@Override
	public void register(String username, String password) {
		if(checkUsername(username,Logininfo.USERTYPE_NORMAL) == false){
			//用户名存在
			throw  new RuntimeException("用户名已存在");
		}
		Logininfo logininfo = new Logininfo();
		logininfo.setUsername(username);  
		logininfo.setPassword(MD5.encode(password));
		logininfo.setUsertype(Logininfo.USERTYPE_NORMAL);
		logininfoMapper.insert(logininfo);
		// 添加Accont  Userinfo
		// Accont, Userinfo 添加id   --> 刚刚添加Logininfo的id
		
		//System.out.println(logininfo.getId());
		//创建Account对象
		Account account = new Account();
		account.setId(logininfo.getId());
		accountMapper.insert(account);
		
		Userinfo userinfo = new Userinfo();
		userinfo.setId(logininfo.getId());
		userinfoMapper.insert(userinfo);
		
	}
}
