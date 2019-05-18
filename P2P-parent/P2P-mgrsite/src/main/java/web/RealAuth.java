package web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pojo.Applier;
import pojo.QueryVo;
import pojo.Realauth;
import service.IRealAuthService;
import util.JsonResult;
import util.RequireLogin;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class RealAuth {
	@Autowired
	private IRealAuthService realAuthService;
	@RequestMapping("/realAuth.action")
	@RequireLogin
	public String realAuthlist(HttpServletRequest request,QueryVo vo,@RequestParam(required=true,defaultValue="1")Integer currentPage) throws Exception{
		//System.out.println(PageHelper.class);
		PageInfo list = realAuthService.queryByPage(vo,currentPage);
		request.setAttribute("pageResult", list);
		request.setAttribute("qo", vo);
		return "forward:WEB-INF/views/realAuth/list.jsp";
	}
	@RequestMapping("/realAuth_audit.action")
	@RequireLogin
	@ResponseBody
	public JsonResult realAuth_audit(Integer id,Integer state,String remark) throws Exception{
		JsonResult json = new JsonResult();
		try {
			realAuthService.addState(id,state,remark);
			json.setSuccess(true);
			return json;
		} catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("审核失败,请稍后重试!");
			return json;
		}
	}
}
