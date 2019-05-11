package dao;

import pojo.Account;

public interface AccountMapper {

	void insert(Account account) throws Exception;

	Account queryById(long i)  throws Exception;

}
