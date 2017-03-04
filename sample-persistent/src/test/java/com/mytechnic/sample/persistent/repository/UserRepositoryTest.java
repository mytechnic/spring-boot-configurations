package com.mytechnic.sample.persistent.repository;

import com.mytechnic.sample.persistent.PersistentApplicationTest;
import com.mytechnic.sample.persistent.repository.entity.UserEntity;
import com.mytechnic.sample.persistent.repository.entity.UserLoginHistoryEntity;
import com.mytechnic.sample.persistent.type.Gender;
import com.mytechnic.sample.persistent.type.UserGrade;
import com.mytechnic.sample.persistent.type.UserStatus;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
	public void findTest() {
		UserEntity userEntity = userRepository.findOne(1);

		log.debug("userEntity = {}", userEntity);
		log.debug("userLoginHistoryEntityList = {}", userEntity.getUserLoginHistoryEntityList());
	}

	@Test
	@Transactional
	@Rollback(false)
	public void saveTest() {

		UserEntity userEntity = UserEntity.builder()
			.grade(UserGrade.USER)
			.status(UserStatus.NORMAL)
			.email("test@sample.com")
			.password("xmxmxmxm")
			.gender(Gender.MALE)
			.created(LocalDateTime.now())
			.build();
		userRepository.save(userEntity);

		userEntity.setUserLoginHistoryEntityList(new ArrayList<>());
		userEntity.getUserLoginHistoryEntityList().add(
			UserLoginHistoryEntity.builder()
				.userId(userEntity.getUserId())
				.created(LocalDateTime.now())
				.build()
		);
	}

	@Test
	@Transactional
	@Rollback(false)
	public void deleteTest() {

		userRepository.deleteByEmail("test@sample.com");
	}
}