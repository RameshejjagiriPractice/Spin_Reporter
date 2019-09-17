package com.spin.main.repository;
//jhansi


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.spin.main.model.categorymaster;

@Repository
@EnableAutoConfiguration
@EnableJpaRepositories
public interface CategoryRepository extends CrudRepository<categorymaster, String>{
	

}
