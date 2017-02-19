package com.mytechnic.sample.persistence.mapper;

import com.mytechnic.sample.persistence.mapper.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@Mapper
public interface UserMapper {

    UserDto findOne(Integer userId);
}
