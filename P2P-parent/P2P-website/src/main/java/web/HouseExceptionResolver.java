package web;

import exception.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常处理器
 * @author suke
 *
 */
@Component
public class HouseExceptionResolver implements HandlerExceptionResolver {

	//专门处理异常
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object target, Exception e) {
		ModelAndView modelAndView = new ModelAndView();
		  if(e  instanceof LoginInfoException){
			  modelAndView.addObject("error", e.getMessage());
		  }else{
			  modelAndView.addObject("error", "系统开小差了,请稍后重试!");
		  }
		  modelAndView.setViewName("error");
		return modelAndView;
	}
}
