package service;

import java.util.List;

import pojo.Logininfo;
public interface UserService {
	boolean login(String username,String password ,Integer usertype, String ip) throws Exception;

	int register(String username, String password) throws Exception;

	String checkUsername(String username,Integer usertype) throws Exception;
}
