package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import util.UserContext;
import util.RequireLogin;


public class LoginCheckInterceptor /*implements  HandlerInterceptor*/ extends  HandlerInterceptorAdapter {

/*	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}*/

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//判断handler使用时Controller中一个处理请求的方法
		if(handler instanceof HandlerMethod){
			HandlerMethod handlerMethod = (HandlerMethod)handler;
			//获取处理请求方法上的注解
			RequireLogin rl = handlerMethod.getMethodAnnotation(RequireLogin.class);
			//判断是否有该注解
			if(rl != null && UserContext.getCurrent() == null ){ //说明该方法需要访问控制, 如果登录, 跳转到login.html
				response.sendRedirect("login.html");
				return false;
			}
		}
		return super.preHandle(request, response, handler);
	}
}
