package web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
			boolean user =  userService.login(username, password,Logininfo.USERTYPE_SYSTEM,request.getRemoteAddr());
			if(user){
				map.put("success", true);
			}else{
				map.put("msg", "用户名或者密码错误");
			}
		} catch (LoginInfoException e) {
			// TODO Auto-generated catch block
			map.put("msg", e.getMessage());
		}
		return map;
	}
}
