package service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IplogMapper;
import dao.UserMapper;
import exception.LoginInfoException;
import pojo.Iplog;
import pojo.Logininfo;
import util.UserContext;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private IplogMapper iplogMapper;
	@Override
	public boolean login(String username, String password,Integer usertype, String ip) throws Exception {
		Iplog iplog = new Iplog();
		iplog.setIp(ip);
		iplog.setLogintime(new Date());
		iplog.setUsername(username);
		iplog.setLoginstate(Iplog.LOGINSTATE_FAILED);
		iplog.setLogintype(usertype);
		Logininfo  current = userMapper.queryUserInfo(username, password, usertype);
		if(current != null){
			iplog.setLogininfoid(current.getId());
			
			if(current.getState() == Logininfo.STATE_LOCK){
				iplogMapper.insert(iplog);
				throw  new LoginInfoException("账户被锁定,请联系管理员!");
			}
			if(current.getState() == Logininfo.STATE_DELETE){
				iplogMapper.insert(iplog);
				throw  new LoginInfoException("账户已注销,重新创建个账号或联系管理员吧!");
			}
			UserContext.setCurrent(current);
			iplog.setLoginstate(Iplog.LOGINSTATE_SUCCESS);
		}
		iplogMapper.insert(iplog);
		return current != null;
	}
	@Override
	public int register(String username, String password) throws Exception {
		return userMapper.addUserinfo(username,password);
	}
	@Override
	public String checkUsername(String username,Integer usertype) throws Exception {
		return userMapper.queryUsernameInfo(username,usertype);
	}

}
