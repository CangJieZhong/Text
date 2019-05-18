package service;

import java.util.List;

import com.github.pagehelper.PageInfo;

import pojo.QueryVo;
import pojo.Realauth;

public interface IRealAuthService {

	void saveRealAuth(Realauth realauth) throws Exception;

	PageInfo queryByPage(QueryVo vo,Integer pageIndex) throws Exception;

	void addState(Integer id, Integer state,String remark) throws Exception;

}
