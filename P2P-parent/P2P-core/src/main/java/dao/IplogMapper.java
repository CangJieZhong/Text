package dao;

import java.util.Date;

import pojo.Iplog;

public interface IplogMapper {
	void insert(Iplog iplog)  throws Exception;

	Date querylastLoginTimeById(Long id)  throws Exception;
}
