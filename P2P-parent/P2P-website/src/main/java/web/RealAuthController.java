package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import util.RequireLogin;
import util.UploadUtil;

@Controller
public class RealAuthController {
	
	@RequestMapping("realAuth.action")
	@RequireLogin
	public String realAuth() {
		return "forward:WEB-INF/views/realAuth.jsp";
	}
	
	@RequestMapping("realAuth_upload")
	@ResponseBody
	public String realAuthUpload(MultipartFile file) {
		String fileName = UploadUtil.upload(file);
		return "/upload/"+fileName;
	}
}
