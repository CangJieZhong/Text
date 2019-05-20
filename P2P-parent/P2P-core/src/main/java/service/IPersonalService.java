package service;

import java.util.List;
import java.util.Map;

import pojo.QueryVo;
import pojo.Realauth;

public interface IPersonalService {
	/**
	 * 获取个人信息及认证状态
	 * @return 个人信息和认证状态的map集合
	 * @throws Exception
	 */
	Map<String, Object> queryPersonal() throws Exception;
	/**
	 * 添加电话号码
	 * @param phoneNumber 电话号码
	 * @throws Exception
	 */
	void updatePhoneNumber(String phoneNumber) throws Exception;
	/**
	 * 添加邮箱
	 * @param email 邮箱
	 * @param code 生成的UUID
	 * @throws Exception
	 */
	void saveEmail(String email,String code) throws Exception;
	/**
	 * 验证邮箱是否已存在
	 * @param email 邮箱
	 * @return 
	 * @throws Exception
	 */
	Map<String, Object> checkEmail(String email) throws Exception;

	
}
