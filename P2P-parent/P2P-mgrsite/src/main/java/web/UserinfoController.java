package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import exception.LoginInfoException;
import pojo.Logininfo;
import service.ILogininfoService;
import util.JsonResult;
import util.RequireLogin;

@Controller
public class UserinfoController {
	@Autowired
	private ILogininfoService logininfoService;
	@RequestMapping(path="/login.action",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult  login(String username,String password,HttpServletRequest request) throws Exception{
		JsonResult json = new JsonResult();
		try {
			boolean isOk = logininfoService.login(username, password, Logininfo.USERTYPE_SYSTEM, request.getRemoteAddr());
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
	@RequestMapping("/index.action")
	@RequireLogin
	public String toIndex(){
		return "forward:WEB-INF/views/main.jsp";
		
	}
}
