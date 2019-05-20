package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.RealAuthMapper;
import dao.UserinfoMapper;
import pojo.AddRealAuth;
import pojo.QueryVo;
import pojo.Realauth;
import pojo.Userinfo;
import util.BitStateUtil;
import util.UserContext;

@Service
public class RealAuthServiceImpl implements IRealAuthService {
	@Autowired
	private UserinfoMapper userinfoMapper;
	@Autowired
	private RealAuthMapper realAuthMapper;
	@Override
	public void saveRealAuth(Realauth realauth) throws Exception {
		realauth.setApplier_id(UserContext.getCurrent().getId());
		realauth.setApplyTime(new Date());
		realauth.setState(Realauth.STATE_APPLYED);
		realAuthMapper.addRealAuth(realauth);
	}
	@Override
	public PageInfo queryByPage(QueryVo vo,Integer pageIndex) throws Exception {
		PageHelper.startPage(pageIndex,1);
		PageInfo pageInfo = new PageInfo<>(realAuthMapper.queryAllRealauth(vo));
		return pageInfo;
	}
	@Override
	public void addState(Integer id, Integer state,String remark) throws Exception{
		// TODO Auto-generated method stub
		if(state==Realauth.STATE_TRUE){
			/**用户id*/
			Realauth re = realAuthMapper.queryById(id);
			
			/**获取用户状态码*/
			//通过申请人id查找userinfo表数据获取申请的状态码
			long ustate = userinfoMapper.queryUserInfoById(re.getApplier_id()).getBitState();
			int bitstate= (int) ustate;
			//把状态码修改为新的状态码
			int newrealauthid = BitStateUtil.addState(bitstate,
					BitStateUtil.OP_REAL_AUTH);
			AddRealAuth addAuth = new AddRealAuth();
			addAuth.setIdNumber(re.getIdNumber());
			addAuth.setRealauth_id(id);
			addAuth.setRealName(re.getRealname());
			addAuth.setNewRealauthid(newrealauthid);
			addAuth.setUserId((int) re.getApplier_id());
			userinfoMapper.addRealauthid(addAuth);
		}
		realAuthMapper.addRealAuthStateById(id,state,remark,new Date(),UserContext.getCurrent().getId());
	}
	@Override
	public List<Realauth> queryByUid() {
		// TODO Auto-generated method stub
		return realAuthMapper.queryByUid(UserContext.getCurrent().getId());
	}
}
