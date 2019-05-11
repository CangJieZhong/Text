package dao;

import org.apache.ibatis.annotations.Param;

import pojo.Logininfo;

public interface LogininfoMapper {
	Logininfo  queryByUsernameAndPassword(@Param("username")String username,@Param("password")String password,@Param("usertype")int usertype) throws Exception;

	int getCountByUsername(@Param("username") String username,@Param("usertype") int usertype) throws Exception;

	/**
	 * 添加
	 * @param logininfo
	 */
	void insert(Logininfo logininfo) throws Exception;
}
