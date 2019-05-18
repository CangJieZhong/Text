package web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pojo.Realauth;
import service.IRealAuthService;
import util.RequireLogin;
import util.UploadUtil;

@Controller
public class RealAuthController {
	@Autowired
	private IRealAuthService realAuthService;
	@RequestMapping("realAuth.action")
	@RequireLogin
	public String realAuth() {
		return "forward:WEB-INF/views/realAuth.jsp";
	}
	
	@RequestMapping("realAuth_upload.action")
	@ResponseBody
	@RequireLogin
	public String realAuthUpload(MultipartFile file) {
		String fileName = UploadUtil.upload(file);
		return "/upload/"+fileName;
	}
	@RequestMapping("realAuth_save.action")
	@RequireLogin
	public String addrealAuth(Realauth realauth,HttpServletRequest request){
		try {
			realAuthService.saveRealAuth(realauth);
			request.setAttribute("auditing", true);
			return "forward:WEB-INF/views/realAuth_result.jsp";
		} catch (Exception e) {
			request.setAttribute("error", "系统上传信息失败,请稍后重试");
			return "error";
		}
		
	}
}
