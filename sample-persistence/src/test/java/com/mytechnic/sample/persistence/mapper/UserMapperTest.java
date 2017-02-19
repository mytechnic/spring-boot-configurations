package com.mytechnic.sample.persistence.mapper;

import com.mytechnic.sample.persistence.PersistenceApplicationTest;
import com.mytechnic.sample.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@Slf4j
public class UserMapperTest extends PersistenceApplicationTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findOne() {
        userMapper.findOne(1);
    }

    @Test
    public void findOne2() {
        userRepository.findOne(1);
    }
}