package com.mytechnic.sample.persistent.repository;

import com.mytechnic.sample.persistent.repository.entity.UserLoginHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
public interface UserLoginHistoryRepository extends JpaRepository<UserLoginHistoryEntity, Integer> {

}
