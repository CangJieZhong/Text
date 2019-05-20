package web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pojo.Person_Auth;
import pojo.Realauth;
import service.IPersonalService;
import service.IRealAuthService;
import util.RequireLogin;
import util.UploadUtil;

@Controller
public class RealAuthController {
	@Autowired
	private IRealAuthService realAuthService;
	@RequestMapping("realAuth.action")
	@RequireLogin
	public String realAuth(HttpServletRequest request) throws Exception {
		//通过logininfo的id查询申请通过记录
		List<Realauth> list =realAuthService.queryByUid();
		//如果有申请记录,申请成功或者申请中
		if(list!=null && list.size()>0){
			for (Realauth realauth : list) {
				//如果是申请成功,把该对象放域里
				if(realauth.getState().equals(1)){
					request.setAttribute("realAuth", realauth);
					//申请失败,把auditing(页面判断的依据)设置为true
				}else{
					request.setAttribute("auditing", true);
				}
			}
			//有申请记录,并且申请记录不是拒绝,转到realAuth_result
			return "forward:WEB-INF/views/realAuth_result.jsp";
		}
		//上一次申请失败或没申请过,转到realAuth
		return "forward:WEB-INF/views/realAuth.jsp";
	}
	/**
	 * 异步上传文件
	 * @param file 文件
	 * @return 
	 */
	@RequestMapping("realAuth_upload.action")
	@ResponseBody
	@RequireLogin
	public String realAuthUpload(MultipartFile file) {
		String fileName = UploadUtil.upload(file);
		return "/upload/"+fileName;
	}
	/**
	 * 添加一条实名认证申请记录
	 * @param realauth 实名认证对象
	 * @param request 跳转页面需要往域里存东西
	 * @return
	 */
	@RequestMapping("realAuth_save.action")
	@RequireLogin
	public String addrealAuth(Realauth realauth,HttpServletRequest request){
		try {
			realAuthService.saveRealAuth(realauth);
			//realAuth_result的判断依据
			request.setAttribute("auditing", true);
			return "forward:WEB-INF/views/realAuth_result.jsp";
		} catch (Exception e) {//如果发生异常,则跳转到error页面,并提供错误信息
			request.setAttribute("error", "系统上传信息失败,请稍后重试");
			return "error";
		}
		
	}
}
