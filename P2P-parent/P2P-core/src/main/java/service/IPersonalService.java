package service;

import java.util.List;
import java.util.Map;

import pojo.QueryVo;
import pojo.Realauth;

public interface IPersonalService {

	Map<String, Object> queryPersonal() throws Exception;

	void updatePhoneNumber(String phoneNumber) throws Exception;

	void saveEmail(String email,String code) throws Exception;
	
	Map<String, Object> checkEmail(String email) throws Exception;

	
}
