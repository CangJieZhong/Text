package dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import pojo.Iplog;

public interface IplogMapper {
	void insert(Iplog iplog)  throws Exception;

	Date querylastLoginTimeById(@Param("username")String username,@Param("logintype")int logintype,@Param("loginState")int loginState)  throws Exception;
}
