package service;

import exception.LoginInfoException;

public interface ILogininfoService {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public boolean  login(String username, String password,int  usertype, String ip) throws  LoginInfoException ;

	/**
	 * 验证用户名是否存在
	 * @param username
	 * @param usertypeNormal
	 * @return  false  存在      true  不存在
	 */
	public boolean checkUsername(String username, int usertype);

	/**
	 * 注册
	 * @param username
	 * @param password
	 */
	public void register(String username, String password);
}
