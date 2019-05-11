package web;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.IPersonalService;
import util.MailUtil;
import util.SimpleHttpClient;

@Controller
public class PersonalController {
	@Autowired
	private IPersonalService personalService;
	
	@RequestMapping(path = "/personal.action")
	public String personal(HttpServletRequest request) throws Exception {
		Map<String, Object> map = personalService.queryPersonal();
		request.setAttribute("account", map.get("account"));
		request.setAttribute("date", map.get("lastLoginTime"));
		request.setAttribute("person_Auth", map.get("person_Auth"));
		return "forward:WEB-INF/views/personal.jsp";
	}


	@RequestMapping("/sendPhoneMessage.action")
	//@ResponseBody
	public void sendPhoneMessage(HttpServletRequest request,
			String phoneNumber) throws Exception {
		// 随机生成6位数的验证码
		String checkCode = "";
		Random random = new Random();
		for (int i = 0; i < 6; i++) {
			checkCode += random.nextInt(10);
		}
		// String result = SimpleHttpClient.sendPhoneMessage(phoneNumber,
		// checkCode);
		request.getSession().removeAttribute("sendMessage");
		// if(result.indexOf("操作成功")!=-1){
		Map<String, String> userPhoneMsg = new HashMap<String, String>();
		userPhoneMsg.put("sendMessage", checkCode);
		System.out.println(checkCode);
		userPhoneMsg.put("phoneNumber", phoneNumber);
		request.getSession().setAttribute("userPhoneMsg", userPhoneMsg);
		// }
	}
	@RequestMapping("/savePhoneNumber.action")
	@ResponseBody
	public Map<String, Object> savePhoneNumber(HttpServletRequest request,String code,String phoneNumber) throws Exception{
		Map<String, Object> map = new HashMap<>();
		Map<String, String> userPhoneMsg = (Map<String, String>) request.getSession().getAttribute("userPhoneMsg");
		if(code.equals(userPhoneMsg.get("sendMessage"))&&phoneNumber.equals(userPhoneMsg.get("phoneNumber"))){
			map.put("success", true);
			personalService.updatePhoneNumber(phoneNumber);
		}else{
			map.put("ErroMsg", "验证码错误,请重新输入");
		}
		return map;
	}
	@RequestMapping("/checkEmail.action")
	@ResponseBody
	public Map<String, Object> checkEmail(HttpServletRequest request,String email) throws Exception{
		return personalService.checkEmail(email);
	}
	@RequestMapping("/saveEmail.action")
	public String saveEmail(HttpServletRequest request,String email,String code) throws Exception{
		
			try {
				personalService.saveEmail(email,code);
				return "forward:personal.action";
			} catch (Exception e) {
				request.setAttribute("error", "系统出现了故障,请稍后重试");
				return "forward:error.jsp";
			}
	}
}
