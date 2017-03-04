package com.mytechnic.sample.persistent.repository;

import com.mytechnic.sample.persistent.repository.entity.QUserEntity;
import com.mytechnic.sample.persistent.repository.entity.UserEntity;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
public class UserRepositoryImpl extends QueryDslRepositorySupport implements UserRepositoryCustom {

	public UserRepositoryImpl() {
		super(UserEntity.class);
	}

	@Override
	public Long getUserExists(String email) {
		QUserEntity user = QUserEntity.userEntity;

		BooleanBuilder booleanBuilder = new BooleanBuilder();
		booleanBuilder.and(user.email.eq(email));

		return new JPAQuery<UserEntity>(getEntityManager())
			.select(user.count())
			.from(user)
			.where(booleanBuilder)
			.fetchOne();
	}
}
