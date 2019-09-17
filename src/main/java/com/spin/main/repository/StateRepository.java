package com.spin.main.repository;
import java.util.List;

//sandeepK
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spin.main.model.statemaster;
@Repository
@EnableAutoConfiguration
@EnableJpaRepositories
public interface StateRepository extends CrudRepository<statemaster, String> {
	
	@Query(value = "select * from statemaster where countryid=:CountryId", nativeQuery = true)
	List<statemaster> countryById(@Param("CountryId") Integer CountryId);

}
