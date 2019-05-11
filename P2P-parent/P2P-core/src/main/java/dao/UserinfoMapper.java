package dao;

import org.apache.ibatis.annotations.Param;

import pojo.Userinfo;

public interface UserinfoMapper {
	void insert(Userinfo userinfo);
	Userinfo queryUserInfoById(Long id);
	void updatePhoneNumber(@Param("phoneNumber")String phoneNumber,@Param("state") int newrealauthid,@Param("id") Long id);
	int queryEmailInfo(@Param("email")String email);
	void addEmail(@Param("email")String email,@Param("state") int newrealauthid,@Param("id") Long id) throws Exception;
}
