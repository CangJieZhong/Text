package service;

import exception.LoginInfoException;

public interface ILogininfoService {
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception 
	 */
	public boolean  login(String username, String password,int  usertype, String ip) throws  LoginInfoException, Exception ;

	/**
	 * 验证用户名是否存在
	 * @param username
	 * @param usertypeNormal
	 * @return  false  存在      true  不存在
	 * @throws Exception 
	 */
	public boolean checkUsername(String username, int usertype) throws Exception;

	/**
	 * 注册
	 * @param username
	 * @param password
	 * @throws Exception 
	 */
	public void register(String username, String password) throws Exception;
}
