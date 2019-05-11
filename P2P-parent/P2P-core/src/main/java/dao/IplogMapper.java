package dao;

import java.util.Date;

import pojo.Iplog;

public interface IplogMapper {
	void insert(Iplog iplog);

	Date querylastLoginTimeById(Long id);
}
