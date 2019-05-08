package util;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import pojo.Logininfo;
/**
 * 封装获取session,以及往HttpSession存放数据
 * @author suke
 *
 */
public class UserContext {
	private static String USER_IN_SESSION = "current";
    
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
	
}