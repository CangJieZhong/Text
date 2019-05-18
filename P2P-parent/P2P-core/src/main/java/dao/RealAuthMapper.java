package dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.Applier;
import pojo.QueryVo;
import pojo.Realauth;

public interface RealAuthMapper {

	void addRealAuth(Realauth realauth) throws Exception;
	List<Applier> queryAllRealauth(@Param("vo")QueryVo vo) throws Exception;
	void addRealAuthStateById(@Param("id")long id, @Param("state")Integer state,@Param("remark")String remark,@Param("auditTime")Date auditTime,@Param("auditor_id")long auditor_id);
}
