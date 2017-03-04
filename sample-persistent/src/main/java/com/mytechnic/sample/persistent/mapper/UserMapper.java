package com.mytechnic.sample.persistent.mapper;

import com.mytechnic.sample.persistent.mapper.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@Mapper
public interface UserMapper {

	UserDto findOne(Integer userId);
}
