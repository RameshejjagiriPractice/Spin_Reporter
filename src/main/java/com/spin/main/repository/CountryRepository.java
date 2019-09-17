package com.spin.main.repository;
//sandeepK

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spin.main.model.countrymaster;
import com.spin.main.model.usermaster;
@Repository
@EnableAutoConfiguration
@EnableJpaRepositories
public interface CountryRepository extends CrudRepository<countrymaster, String>{

	
	
}
