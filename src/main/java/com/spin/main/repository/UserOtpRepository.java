package com.spin.main.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spin.main.model.UserOtp;

@Repository
public interface UserOtpRepository extends CrudRepository<UserOtp, Integer> {
	
	@Query(value = "  select * from userotp where userid=:userid and isactive=:isactive", nativeQuery = true)
	UserOtp getUserOtp(@Param("userid") Integer userid,@Param("isactive") Integer isactive);

	@Query(value = "  select *from userotp where userid=:userid", nativeQuery = true)
	UserOtp getExitUserOtp(@Param("userid") Integer userid);
	
	@Modifying
	@Transactional
	@Query(value = " update userotp  set createdon=?,isactive=?,otpcode=? where otpid=?", nativeQuery = true)
	int updateExictUserOtp( java.util.Date createdon,Integer isactive,String otpcode,Integer otpId);
	
	@Modifying
	@Transactional
	@Query(value = " update userotp  set isactive=?,usedon=? where otpid=?", nativeQuery = true)
	int updateUserOtp(Integer isactive, java.util.Date  usedon,Integer otpId);
	
}