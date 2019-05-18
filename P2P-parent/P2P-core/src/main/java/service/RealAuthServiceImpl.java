package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import dao.RealAuthMapper;
import pojo.QueryVo;
import pojo.Realauth;
import util.UserContext;

@Service
public class RealAuthServiceImpl implements IRealAuthService {
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
		realAuthMapper.addRealAuthStateById(id,state,remark,new Date(),UserContext.getCurrent().getId());
	}
}
