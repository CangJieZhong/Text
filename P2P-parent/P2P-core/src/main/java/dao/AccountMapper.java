package dao;

import pojo.Account;

public interface AccountMapper {

	void insert(Account account);

	Account queryById(long i);

}
