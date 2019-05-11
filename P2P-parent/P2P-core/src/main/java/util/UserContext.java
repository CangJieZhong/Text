package util;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import pojo.Logininfo;
/**
 * 封装获取HttpSession,以及往HttpSession存放数据
 * @author cangjie
 *
 */
public class UserContext {
	private static String USER_IN_SESSION = "current";
	private static String EMAIL_IN_SESSION = "emailMsg";
	/**
	 * 获取HttpSession的方法
	 */
	private  static HttpSession  getHttpSession(){
		return ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest().getSession();
	}
	
	public static  Logininfo  getCurrent(){
		return (Logininfo) getHttpSession().getAttribute(USER_IN_SESSION);
	}
	public static void setCurrent(Logininfo logininfo){
		getHttpSession().setAttribute(USER_IN_SESSION, logininfo);
	}
	public static  Map<String, Object>  getEmailMsg(){
		return (Map<String, Object>) getHttpSession().getAttribute(EMAIL_IN_SESSION);
	}
	public static void setEmailMsg(Map<String, Object> emailMsg){
		getHttpSession().setAttribute(EMAIL_IN_SESSION, emailMsg);
	}
}
