package com.spin.main.repository;
//sandeepK
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spin.main.model.languagemaster;
@Repository
@EnableAutoConfiguration
@EnableJpaRepositories
public interface LanguageRepository extends CrudRepository<languagemaster, String> {

}
