package com.spin.main.repository;
//sandeepK
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.spin.main.model.usertypemaster;

@Repository
@EnableAutoConfiguration
@EnableJpaRepositories
public interface usertypemasterRepository extends JpaRepository<usertypemaster, Integer> {

}
