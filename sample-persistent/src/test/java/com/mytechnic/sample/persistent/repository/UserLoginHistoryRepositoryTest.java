package com.mytechnic.sample.persistent.repository;

import com.mytechnic.sample.persistent.PersistentApplicationTest;
import com.mytechnic.sample.persistent.repository.entity.UserLoginHistoryEntity;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.03.04.
 */
@Slf4j
public class UserLoginHistoryRepositoryTest extends PersistentApplicationTest {

	@Autowired
	private UserLoginHistoryRepository userLoginHistoryRepository;

	@Test
	@Transactional
	public void findTest() {

		UserLoginHistoryEntity userLoginHistoryEntityList = userLoginHistoryRepository.findOne(1);

		log.debug("userLoginHistoryEntityList = {}", userLoginHistoryEntityList);
		log.debug("userEntity = {}", userLoginHistoryEntityList.getUserEntity());
	}
}