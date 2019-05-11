package dao;

import org.apache.ibatis.annotations.Param;

import pojo.Userinfo;

public interface UserinfoMapper {
	void insert(Userinfo userinfo)  throws Exception;
	Userinfo queryUserInfoById(Long id) throws Exception;
	void updatePhoneNumber(@Param("phoneNumber")String phoneNumber,@Param("state") int newrealauthid,@Param("id") Long id) throws Exception;
	int queryEmailInfo(@Param("email")String email) throws Exception;
	void addEmail(@Param("email")String email,@Param("state") int newrealauthid,@Param("id") Long id) throws Exception;
}
