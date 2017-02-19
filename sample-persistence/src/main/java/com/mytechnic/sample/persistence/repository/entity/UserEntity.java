package com.mytechnic.sample.persistence.repository.entity;

import com.mytechnic.sample.persistence.type.Gender;
import com.mytechnic.sample.persistence.type.UserGrade;
import com.mytechnic.sample.persistence.type.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017-02-19
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user")
public class UserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "grade")
    private UserGrade grade;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserStatus status;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "updated", updatable = false)
    private LocalDateTime updated;

    @Column(name = "created")
    private LocalDateTime created;
}
