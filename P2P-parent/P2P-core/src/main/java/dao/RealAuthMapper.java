package dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Applier;
import pojo.QueryVo;
import pojo.Realauth;

public interface RealAuthMapper {
	/**
	 * 添加一条实名认证数据
	 * @param realauth 实名认证对象
	 * @throws Exception
	 */
	void addRealAuth(Realauth realauth) throws Exception;
	/**
	 * 高级查询全部
	 * @param vo 条件
	 * @return list集合
	 * @throws Exception
	 */
	List<Applier> queryAllRealauth(@Param("vo")QueryVo vo) throws Exception;
	/**
	 * 后台审核修改
	 * @param id 实名认证表的id
	 * @param state 实名认证的状态(审核失败或审核成功)
	 * @param remark 备注
	 * @param auditTime 审核时间
	 * @param auditor_id 审核人id
	 */
	void addRealAuthStateById(@Param("id")long id, @Param("state")Integer state,@Param("remark")String remark,@Param("auditTime")Date auditTime,@Param("auditor_id")long auditor_id);
	/**
	 * 通过id查找表数据
	 * @param id 实名认证表的id
	 * @return 实名认证对象
	 */
	Realauth queryById(@Param("id")Integer id);
	/**
	 * 
	 * @param applier_id 申请人id
	 * @return 实名认证对象
	 */
	List<Realauth> queryByUid(@Param("applier_id")Long applier_id);
}
