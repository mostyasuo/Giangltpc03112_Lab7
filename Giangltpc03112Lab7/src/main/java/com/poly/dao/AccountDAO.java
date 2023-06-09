package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.model.Account;


public interface AccountDAO extends JpaRepository<Account, String>{
		@Query(value = "SELECT * FROM dbo.Accounts WHERE Username = :username",nativeQuery = true)
	Account findAccount(@Param("username") String username);
}
