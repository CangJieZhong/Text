package service;

import java.util.Map;

public interface IPersonalService {

	Map<String, Object> queryPersonal();

	void updatePhoneNumber(String phoneNumber);

	Map<String, Object> checkOrSaveEmail(String email);
	
}
