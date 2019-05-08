package web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exception.LoginInfoException;
import pojo.Logininfo;
import service.UserService;

@RestController
public class UserinfoController {
	Map<Object, Object> map;
	@Autowired
	private UserService userService;
	@RequestMapping("/login.action")
	public Map<Object, Object> login(String username,String password,HttpServletRequest request) throws Exception{
		map = new HashMap<>();
		try {
			boolean user =  userService.login(username, password,Logininfo.USERTYPE_NORMAL,request.getRemoteAddr());
			
			if(user){
				map.put("success", true);
			}else{
				map.put("msg", "用户名或者密码错误");
			}
		} catch (LoginInfoException e) {
			map.put("msg", e.getMessage());
		}
		return map;
	}
	@RequestMapping("/register.action")
	public Map<Object, Object> register(String username,String password) throws Exception{
		int len = userService.register(username,password);
		map = new HashMap<>();
		if(len>0){
			map.put("success", true);
		}
		return map;
	}
	@RequestMapping("/checkUsername.action")
	public boolean checkUsername(String username) throws Exception{
		String usernameInfo =  userService.checkUsername(username,Logininfo.USERTYPE_NORMAL);
		if(usernameInfo==null || usernameInfo==""){
			return true;
		}
			return false;
	}
}
