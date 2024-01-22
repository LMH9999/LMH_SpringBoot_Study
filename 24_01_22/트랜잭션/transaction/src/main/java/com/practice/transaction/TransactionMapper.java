package com.practice.transaction;


import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TransactionMapper {


    Account getAccountById(long accountId);
    Account getAccountByIdWrongSql(long accountId);

    void updateAccountBalance(Account account);

    int insertAccount(Account user);


}
