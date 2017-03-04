package com.mytechnic.sample.persistent.repository.entity;

import com.mytechnic.sample.persistent.type.Gender;
import com.mytechnic.sample.persistent.type.UserGrade;
import com.mytechnic.sample.persistent.type.UserStatus;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author : mytechnic@gmail.com
 * @since : 2017.02.19.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "userLoginHistoryEntity")
@Entity(name = "user")
public class UserEntity implements Serializable {

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

	@OneToMany(mappedBy = "userEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserLoginHistoryEntity> userLoginHistoryEntityList;
}
