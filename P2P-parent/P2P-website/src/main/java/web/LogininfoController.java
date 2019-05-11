package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import exception.LoginInfoException;
import pojo.Logininfo;
import service.ILogininfoService;
import util.JsonResult;

@Controller
public class LogininfoController {

	@Autowired
	private ILogininfoService logininfoService;
	
	@RequestMapping(path="/login.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult  login(String username,String password,HttpServletRequest request) throws Exception{
		JsonResult json = new JsonResult();
		try {
			boolean isOk = logininfoService.login(username, password, Logininfo.USERTYPE_NORMAL, request.getRemoteAddr());
			if(isOk == false){
				json.setSuccess(false);
				json.setMsg("用户名或者密码错误");
			}
		} catch (LoginInfoException e) {
			json.setSuccess(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	@RequestMapping(path="/checkUsername.action",method=RequestMethod.POST)
	@ResponseBody
	public boolean  checkUsername(String username) throws Exception{
		return  logininfoService.checkUsername(username,Logininfo.USERTYPE_NORMAL);
	}
	
	
	
	@RequestMapping(path="/register.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult  register(String username,String password){
		JsonResult json = new JsonResult();
		try{
			logininfoService.register(username,password);
		}catch(Exception e){
			json.setSuccess(false);
		}
		return json;
	}
}
