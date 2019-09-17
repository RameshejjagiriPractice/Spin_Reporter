package com.spin.main.repository;
//sandeepK

import javax.transaction.Transactional;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spin.main.model.usermaster;

@Repository
@EnableAutoConfiguration
@EnableJpaRepositories
public interface usermasterRepository extends CrudRepository<usermaster, Integer> {

	usermaster findByEmailidIgnoreCase(String emailid);

	// User findByUsername(String username);

	@Query(value = "select COUNT(*) from spin.usermaster where isactive=1 ", nativeQuery = true)
	long allUsersCount();

	@Query(value = "select * from usermaster where userid  =:Id and isactive=1 ", nativeQuery = true)
	usermaster userById(@Param("Id") Integer Id);

	// -----------------------------------------------------AndeRanjith----------------------------------------------------------------------------------------
	@Query(value = " select * from  usermaster where isactive=1 and emailid=:emailid", nativeQuery = true)
	usermaster findBySpinReporterUserName(@Param("emailid") String spinReporterUserName);

	@Modifying
	@Transactional
	@Query(value = "update usermaster  set pword = ? where userid = ?", nativeQuery = true)
	int updatePassword(String reEnterPassword, Integer id);

	// -----------------------------------------------------AndeRanjith----------------------------------------------------------------------------------------

}
