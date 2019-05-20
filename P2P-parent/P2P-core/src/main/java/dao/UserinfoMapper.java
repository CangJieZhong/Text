package dao;

import org.apache.ibatis.annotations.Param;

import pojo.AddRealAuth;
import pojo.Userinfo;

public interface UserinfoMapper {
	/**
	 * 添加一条userinfo信息
	 * @param userinfo
	 * @throws Exception
	 */
	void insert(Userinfo userinfo)  throws Exception;
	/**
	 * 通过用户id查询表数据
	 * @param id 用户id
	 * @return userinfo对象
	 * @throws Exception
	 */
	Userinfo queryUserInfoById(Long id) throws Exception;
	/**
	 * 添加电话号码
	 * @param phoneNumber 电话号码
	 * @param newrealauthid 新的状态码
	 * @param id 用户id
	 * @throws Exception
	 */
	void updatePhoneNumber(@Param("phoneNumber")String phoneNumber,@Param("state") int newrealauthid,@Param("id") Long id) throws Exception;
	/**
	 * 查找邮箱是否存在
	 * @param email 要查询的邮箱
	 * @return 行数 如果存在返回的函数大于零
	 * @throws Exception
	 */
	int queryEmailInfo(@Param("email")String email) throws Exception;
	/**
	 * 添加邮箱
	 * @param email 邮箱
	 * @param newrealauthid 新的用户状态码
	 * @param id 用户id
	 * @throws Exception
	 */
	void addEmail(@Param("email")String email,@Param("state") int newrealauthid,@Param("id") Long id) throws Exception;
	/**
	 * 添加实名制信息
	 * @param AddRealAuth 实名制信息内容
	 */
	void addRealauthid(AddRealAuth AddRealAuth);
}
