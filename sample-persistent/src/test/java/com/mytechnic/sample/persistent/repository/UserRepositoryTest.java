package com.mytechnic.sample.persistent.repository;

import com.mytechnic.sample.persistent.PersistentApplicationTest;
import com.mytechnic.sample.persistent.repository.entity.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.03.04.
 */
@Slf4j
public class UserRepositoryTest extends PersistentApplicationTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Transactional
	public void find() {
		UserEntity userEntity = userRepository.findOne(1);

		log.debug("userEntity = {}", userEntity);
		log.debug("userLoginHistoryEntityList = {}", userEntity.getUserLoginHistoryEntity());
	}
}