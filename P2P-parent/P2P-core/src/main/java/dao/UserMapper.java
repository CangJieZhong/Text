package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Logininfo;

public interface UserMapper{
	Logininfo queryUserInfo(@Param("username")String username,@Param("password")String password,@Param("usertype")Integer usertype) throws Exception;

	int addUserinfo(@Param("username")String username,@Param("password")String password)  throws Exception;

	String queryUsernameInfo(@Param("username")String username,@Param("usertype")Integer usertype) throws Exception;
}
