package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import pojo.QueryVo;
import pojo.Realauth;

public interface IRealAuthService {
	/**
	 * 保存一个实名认证信息
	 * @param realauth 实名认证对象
	 * @throws Exception
	 */
	void saveRealAuth(Realauth realauth) throws Exception;
	/**
	 * 分页带高级查询
	 * @param vo 查询条件
	 * @param pageIndex 当前页码
	 * @return PageInfo对象(pageholper中)
	 * @throws Exception
	 */
	PageInfo queryByPage(QueryVo vo,Integer pageIndex) throws Exception;
	/**
	 * 添加审核之后状态码
	 * @param id 申请实名认证记录的id
	 * @param state 申请通过还是申请拒绝状态码
	 * @param remark 备注
	 * @throws Exception
	 */
	void addState(Integer id, Integer state,String remark) throws Exception;
	/**
	 * 通过用户id查找实名认证记录
	 * @return 
	 */
	List<Realauth> queryByUid();

}
