package com.mytechnic.sample.persistence.mapper.dto;

import com.mytechnic.sample.persistence.type.Gender;
import com.mytechnic.sample.persistence.type.UserGrade;
import com.mytechnic.sample.persistence.type.UserStatus;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
@Getter
@Setter
public class UserDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer userId;
    private UserGrade grade;
    private UserStatus status;
    private String email;
    private String password;
    private Gender gender;
    private LocalDateTime updated;
    private LocalDateTime created;
}