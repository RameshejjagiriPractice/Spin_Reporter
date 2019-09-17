package com.spin.main.repository;
//jhansi

import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spin.main.model.subcategorymaster;

@Repository
@EnableAutoConfiguration
@EnableJpaRepositories
public interface SubCategoryRepository extends CrudRepository<subcategorymaster, String> {

	@Query(value = "select * from subcategorymaster where categoryid=:CategoryId", nativeQuery = true)
	List<subcategorymaster> CategoryById(@Param("CategoryId") Integer CategoryId);
}
