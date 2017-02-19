package com.mytechnic.sample.persistence.repository;

import com.mytechnic.sample.persistence.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
public interface UserRepository extends JpaRepository<UserEntity, Integer>, UserRepositoryCustom {

    UserEntity findByEmail(String email);
}
