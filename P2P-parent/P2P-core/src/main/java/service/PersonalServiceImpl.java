package service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo.Account;
import pojo.Person_Auth;
import pojo.Userinfo;
import util.BitStateUtil;
import util.UserContext;
import dao.AccountMapper;
import dao.IplogMapper;
import dao.UserinfoMapper;

@Service
public class PersonalServiceImpl implements IPersonalService {
	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private IplogMapper iplogMapper;
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Override
	public Map<String, Object> queryPersonal() {
		Map<String, Object> map = new HashMap<>();
		Account account = accountMapper.queryById(UserContext.getCurrent().getId());
		map.put("account", account);
		Date lastLoginTime = iplogMapper.querylastLoginTimeById(UserContext.getCurrent().getId());
		map.put("lastLoginTime", lastLoginTime);
		Userinfo ui = userinfoMapper.queryUserInfoById(UserContext.getCurrent().getId());
		/**实名制信息*/
		long realauthid = ui.getBitState();
		Person_Auth pa = new Person_Auth();
		pa.setReal_Auth(BitStateUtil.hasState((int)realauthid, BitStateUtil.OP_REAL_AUTH));
		pa.setMail_Auth(BitStateUtil.hasState((int)realauthid, BitStateUtil.OP_MAIL_AUTH));
		pa.setPhone_Auth(BitStateUtil.hasState((int)realauthid, BitStateUtil.OP_PHONE_AUTH));
		pa.setVip(BitStateUtil.hasState((int)realauthid, BitStateUtil.OP_VIP));
		map.put("person_Auth", pa);
		return map;
	}
	@Override
	public void updatePhoneNumber(String phoneNumber) {
		// TODO Auto-generated method stub
		/**实名认证状态码*/
		long State = userinfoMapper.queryUserInfoById(UserContext.getCurrent().getId()).getBitState();
		int newrealauthid = BitStateUtil.addState((int)State, BitStateUtil.OP_PHONE_AUTH);
		userinfoMapper.updatePhoneNumber(phoneNumber,newrealauthid,UserContext.getCurrent().getId());
	}
	@Override
	public Map<String, Object> checkOrSaveEmail(String email) {
		Map<String, Object> map = null;
		int emailCount = userinfoMapper.queryEmailInfo(email);
		if(emailCount>0){
			map = new HashMap<>();
			map.put("success", false);
			map.put("ErroMsg", "邮箱已被注册,请重新输入邮箱!");
			return map;
		}else{
			map = new HashMap<>();
			
			try {
				long State = userinfoMapper.queryUserInfoById(UserContext.getCurrent().getId()).getBitState();
				int newrealauthid = BitStateUtil.addState((int)State, BitStateUtil.OP_MAIL_AUTH);
				userinfoMapper.addEmail(email,newrealauthid,UserContext.getCurrent().getId());
				map.put("success", true);
			} catch (Exception e) {
				map.put("success", false);
				map.put("ErroMsg", "邮箱保存失败了,请稍后重试!");
			}
		}
		return map;
	}
	
}
